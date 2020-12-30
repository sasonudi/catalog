package com.bhp.catalog.services.impl;

import com.bhp.catalog.repo.ItemRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*my name is udi sasson and the date is 29/12/2020 */

class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl adminService;

    @MockBean
    private ItemRepo itemRepo;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void deleteItem() {
    }

    @Test
    void getOneItem() {
        when(itemRepo.)
    }

    @Test
    void getAllItems() {
    }

    @Test
    void saveItem() {
    }

    @Test
    void updateItem() {
    }

    @Test
    void countItem() {
        when(itemRepo.count()).thenReturn(3L);
        ///.....
    }
}