package com.shopping.item.model;

public class ItemCategory {

    private String code;
    private String value;

    public ItemCategory() {
    }

    public ItemCategory(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static final ItemCategory VEG = new ItemCategory("0","VEG");

    public String getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}
