package ro.fortech.companyproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Integer> {
    Optional<CompanyEntity> findCompanyByCif(String cif);
    void delete(CompanyEntity companyEntity);
}
