package org.academiadecodigo.bootcamp.one_to_many;

/**
 * Created by codecadet on 04/07/16.
 */
public class Product {

    private Integer id;
    private String productName;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
