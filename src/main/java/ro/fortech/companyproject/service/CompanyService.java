package ro.fortech.companyproject.service;

import org.springframework.stereotype.Service;
import ro.fortech.companyproject.dao.CompanyEntity;
import ro.fortech.companyproject.dao.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll().stream().map(CompanyEntity::toPojo).collect(Collectors.toList());
    }

    public Company addCompany(Company company){
        CompanyEntity newCompany = new CompanyEntity();
        newCompany.update(company);
        return companyRepository.save(newCompany).toPojo();
    }

    public Company updateCompany(String companyCif, Company company){
        CompanyEntity saved = companyRepository.findCompanyByCif(companyCif).orElseThrow(() -> new CompanyNotFoundException(company.getName()));
        return companyRepository.save(saved).toPojo();
    }

    public void deleteCompany(String companyCif){
        CompanyEntity deleted = companyRepository.findCompanyByCif(companyCif).orElseThrow(() -> new CompanyNotFoundException(companyCif));
        companyRepository.delete(deleted);
    }
}
