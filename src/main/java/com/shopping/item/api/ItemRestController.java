package com.shopping.item.api;

import com.shopping.item.model.Item;
import com.shopping.item.model.ItemWrapper;
import com.shopping.item.service.ItemBSI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemRestController {

    @Autowired
    private ItemBSI itemService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllItems() throws Exception{
        try {
            ItemWrapper wrapper = new ItemWrapper();
            List<Item> items = itemService.getAllItems();
            wrapper.setItemList(items);
            return new ResponseEntity<Object>(wrapper, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable("id") Long id) throws Exception {
        try{
            Item item = itemService.getItemById(id);
            return new ResponseEntity<Object>(item, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<Object> getItemByCategory(@PathVariable("category") String category) throws Exception{
        try{
            ItemWrapper wrapper = new ItemWrapper();
            List<Item> items = itemService.getItemByCategory(category);
            wrapper.setItemList(items);
            return new ResponseEntity<Object>(wrapper, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addItem(@RequestBody Item item) throws Exception{
        try{
            int i = itemService.addItem(item);
            return new ResponseEntity<Object>("Item added Successfully", HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/multiple")
    public ResponseEntity<Object> addMultipleItems(@RequestBody List<Item> items) throws Exception{
        try{
            String ret = itemService.addMultipleItems(items);
            return new ResponseEntity<Object>(ret, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Object> updateItem(@RequestBody Item item) throws Exception{
        try{
            int i = itemService.updateItem(item);
            return new ResponseEntity<Object>("Item Update Successfully", HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Object> removeItemById(@PathVariable("id") Long id) throws Exception{
        try{
            int i = itemService.removeItemById(id);
            return new ResponseEntity<Object>("Item Removed Successfully", HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<Object> removeAllItems() throws Exception{
        try{
            int i = itemService.removeAll();
            return new ResponseEntity<Object>("All Items Removed Successfully", HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
