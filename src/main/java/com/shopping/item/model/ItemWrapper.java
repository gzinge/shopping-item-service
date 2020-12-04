package com.shopping.item.model;

import java.util.List;

public class ItemWrapper {

    private List<Item> itemList;

    public ItemWrapper() {
    }

    public ItemWrapper(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
