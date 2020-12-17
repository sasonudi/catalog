package com.bhp.catalog.bootstrap;/*my name is udi sasson and the date is 29/11/2020 */

import com.bhp.catalog.beans.Item;
import com.bhp.catalog.beans.ItemType;
import com.bhp.catalog.repo.ItemRepo;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class initData implements CommandLineRunner {

    private final ItemRepo itemRepo;

    @Override
    public void run(String... args) throws Exception {
        Item s1 = Item.builder()
                .itemType(ItemType.SPORTS)
                .name("bat")
                .price(BigDecimal.valueOf(7.5))
                .build();
        Item s2 = Item.builder()
                .itemType(ItemType.SPORTS)
                .name("basketball")
                .price(BigDecimal.valueOf(5.6))
                .build();
        Item s3 = Item.builder()
                .itemType(ItemType.SPORTS)
                .name("Bicycle")
                .price(BigDecimal.valueOf(200))
                .build();
        Item e1 = Item.builder()
                .itemType(ItemType.ELECTRICITY)
                .name("SmartPhone")
                .price(BigDecimal.valueOf(150.6))
                .build();
        Item e2 = Item.builder()
                .itemType(ItemType.ELECTRICITY)
                .name("PcScreen")
                .price(BigDecimal.valueOf(202.6))
                .build();
        Item e3 = Item.builder()
                .itemType(ItemType.ELECTRICITY)
                .name("Washing machine")
                .price(BigDecimal.valueOf(300.50))
                .build();
        Item f1 = Item.builder()
                .itemType(ItemType.FOOD)
                .name("Oranges")
                .price(BigDecimal.valueOf(2.6))
                .build();
        Item f2 = Item.builder()
                .itemType(ItemType.FOOD)
                .name("Avocado")
                .price(BigDecimal.valueOf(10.7))
                .build();
        Item f3 = Item.builder()
                .itemType(ItemType.FOOD)
                .name("Pizza")
                .price(BigDecimal.valueOf(15.3))
                .build();
        Item o1 = Item.builder()
                .itemType(ItemType.OTHER)
                .name("pajamas")
                .price(BigDecimal.valueOf(50.6))
                .build();

        itemRepo.saveAll(Arrays.asList(s1,s2,s3,e1,e2,e3,f1,f2,f3,o1));




    }
}
