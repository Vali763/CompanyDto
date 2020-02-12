package ro.fortech.companyproject.dao;

import lombok.Data;
import ro.fortech.companyproject.service.Company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name="name",unique = true,nullable = false)
    private String name;
    private String cif;

    public Company toPojo(){
        Company pojo = new Company();
        pojo.setName(name);
        pojo.setCif(cif);
        return pojo;
    }

    public CompanyEntity update(Company pojo){
        this.name = pojo.getName();
        this.cif = pojo.getCif();
        return this;
    }

}
