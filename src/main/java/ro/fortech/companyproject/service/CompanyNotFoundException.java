package ro.fortech.companyproject.service;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(String id){super(id);}
}
