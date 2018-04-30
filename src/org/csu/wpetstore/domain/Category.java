package org.csu.wpetstore.domain;

import java.io.Serializable;

/**
 * Created by WZF on 2018/4/25.
 */
public class Category implements Serializable{
    private  static final long serialVersionUID = 1L;
    private String categoryId;
    private String name;
    private String description;

    public Category(String id, String name, String desc) {
        this.categoryId = id;
        this.name = name;
        this.description = desc;
    }
    public Category() {

    }
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return this.getCategoryId();
    }
}
