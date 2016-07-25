package org.academiadecodigo.bootcamp.one_to_many;

import java.util.Set;

/**
 * Created by codecadet on 04/07/16.
 */
public class Category {

    private Integer id;
    private String categoryName;
    private Set<Product> products;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
