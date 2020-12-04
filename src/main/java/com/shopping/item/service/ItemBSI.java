package com.shopping.item.service;

import com.shopping.item.model.Item;

import java.util.List;

public interface ItemBSI {

    public Item getItemById(Long id) throws Exception;

    public List<Item> getAllItems() throws Exception;

    public List<Item> getItemByCategory(String category) throws Exception;

    public int addItem(Item item) throws Exception;

    public String addMultipleItems(List<Item> items) throws Exception;

    public int updateItem(Item item) throws Exception;

    public int removeItemById(Long id) throws Exception;

    public int removeAll() throws Exception;
}
