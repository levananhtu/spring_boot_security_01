package lvat.springbootsecurity01.module01.accessingdatamysql.entity.projection.customer;

public interface CustomerProjection01 extends CustomerProjection {
    String getCustomerName();

    String getContactFirstName();

    String getContactLastName();
}
