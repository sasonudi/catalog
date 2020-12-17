package com.bhp.catalog.controller;/*my name is udi sasson and the date is 30/11/2020 */


import com.bhp.catalog.beans.Item;
import com.bhp.catalog.services.impl.InvalidEntityException;
import com.bhp.catalog.services.interfaces.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;


    @SneakyThrows
    @PostMapping("/item")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItem(@RequestBody Item item)
    {
        adminService.saveItem(item);
    }

    @SneakyThrows
    @PutMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@PathVariable Long id,@RequestBody  Item item)  {
        adminService.updateItem(id,item);

    }

    @SneakyThrows
    @GetMapping("/items/count")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> countItem() {

        return ResponseEntity.ok(adminService.countItem());
    }


    @SneakyThrows
    @DeleteMapping ("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {

        adminService.deleteItem(getOneItem(id),id);
    }

    @SneakyThrows
    @GetMapping("/items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item getOneItem(@PathVariable Long id) {

        return adminService.getOneItem(id);
    }

    @SneakyThrows
    @GetMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Item> getAllItems() {

        return adminService.getAllItems();
    }
}
