package lvat.springbootsecurity01.module01.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "product_lines")
@Entity(name = "ProductLine")
public class ProductLine implements Serializable {
    @Id
    @Column(name = "product_line", nullable = false)
    private String productLine;

    @Column(name = "text_description")
    private String textDescription;

    @Column(name = "html_description")
    private String htmlDescription;

    @Column(name = "image")
    private Byte[] image;

    @OneToMany(targetEntity = Product.class)
//    @JoinColumn(referencedColumnName = "product_line", name = "product_line", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "product_line", name = "product_line")
    private List<Product> productList;

    public ProductLine() {
    }

    public ProductLine(String productLine, String textDescription, String htmlDescription, Byte[] image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    @JsonIgnore
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
