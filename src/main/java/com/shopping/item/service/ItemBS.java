package com.shopping.item.service;

import com.shopping.item.model.Item;
import com.shopping.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemBS implements ItemBSI{

    @Autowired
    private ItemRepository repository;

    @Override
    public Item getItemById(Long id) throws Exception {
        if(id != null) {
            Optional<Item> opt = repository.findById(id);
            if(opt.isPresent()) {
                return opt.get();
            }
        }
        return null;
    }

    @Override
    public List<Item> getAllItems() throws Exception {
        List<Item> allItems = repository.findAll();
        return allItems;
    }

    @Override
    public List<Item> getItemByCategory(String category) throws Exception {
        List<Item> items = new ArrayList<>();
        if(category != null && !category.equals("")){
            items = repository.findAll().stream().filter(item -> item.getCategory().equals(category))
                    .collect(Collectors.toList());
        }
        return items;
    }

    @Override
    public int addItem(Item item) throws Exception {
        if(item != null) {
            Item newItem = new Item();
            newItem.setName(item.getName());
            newItem.setImage(item.getImage());
            newItem.setDescription(item.getDescription());
            newItem.setCategory(item.getCategory());
            newItem.setPrice(item.getPrice());
            newItem.setQtyAvailable(item.getQtyAvailable());
            repository.save(newItem);
            return 1;
        }
        return 0;
    }

    @Override
    public String addMultipleItems(List<Item> items) throws Exception{
        Long addCount = 0l;
        try{
            for(Item item : items){
               int ret =  addItem(item);
               if(ret == 1){
                   addCount++;
               }
            }
            return addCount + " items added successfully";
        }catch(Exception ex) {
            //failed to add item
        }
        return addCount + " items added successfully";
    }

    @Override
    public int updateItem(Item item) throws Exception {
        Item itemToUpdate = getItemById(item.getId());
        if(itemToUpdate != null) {
            itemToUpdate.setName(item.getName());
            itemToUpdate.setImage(item.getImage());
            itemToUpdate.setDescription(item.getDescription());
            itemToUpdate.setCategory(item.getCategory());
            itemToUpdate.setPrice(item.getPrice());
            itemToUpdate.setQtyAvailable(item.getQtyAvailable());
            repository.save(itemToUpdate);
            return 1;
        }
        return 0;
    }

    @Override
    public int removeItemById(Long id) throws Exception {
        Item itemToUpdate = getItemById(id);
        if(itemToUpdate != null) {
            repository.delete(itemToUpdate);
            return 1;
        }
        return 0;
    }

    @Override
    public int removeAll() throws Exception {
        repository.deleteAll();
        return 1;
    }


}
