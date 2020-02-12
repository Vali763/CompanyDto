package ro.fortech.companyproject.dao;

import lombok.Data;

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


}
