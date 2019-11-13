package lvat.springbootsecurity01.module01.accessingdatamysql.entity.projection.customer;

public interface CustomerFullProjection extends CustomerProjection {
    Long getCustomerNumber();

    String getCustomerName();

    String getContactFirstName();

    String getContactLastName();

    String getPhone();

    String getAddressLine1();

    String getAddressLine2();

    String getCity();

    String getState();

    String getPostalCode();

    String getCountry();

    Long getSalesRepEmployeeNumber();

    Double getCreditLimit();

}
