package ro.fortech.companyproject.service;

import lombok.Data;
import ro.fortech.companyproject.controller.CompanyDto;

@Data
public class Company {

    private String cif;

    public CompanyDto toDto(){
        CompanyDto dto = new CompanyDto();
        dto.setCif(cif);
        return dto;
    }

    public Company update(CompanyDto dto){
        this.cif = dto.getCif();
        return this;
    }
}
