package ro.fortech.companyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fortech.companyproject.service.Company;
import ro.fortech.companyproject.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService){ this.companyService = companyService;}

    @GetMapping("/")
    public List<CompanyDto> getAllCompanies(){
        return companyService.getAllCompanies().stream().map(Company::toDto).collect(Collectors.toList());
    }
    @PostMapping("/")
    public CompanyDto addCompany(@RequestBody Company company){
        return companyService.addCompany(company).toDto();
    }
    @PutMapping("/{companyCif}")
    public CompanyDto updateCompany(@PathVariable("companyCif") String companyCif, @RequestBody Company company){
        return companyService.updateCompany(companyCif,company).toDto();
    }
    @DeleteMapping("/{companyCif}")
    public String deleteCompany(@PathVariable("companyCif") String companyCif){
        companyService.deleteCompany(companyCif);
        return "Deleted";
    }
}
