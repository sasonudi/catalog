package com.bhp.catalog.repo;/*my name is udi sasson and the date is 29/11/2020 */

import com.bhp.catalog.beans.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository//לא נדרש
public interface ItemRepo extends JpaRepository<Item,Long> {

    @Query(value = "select count(*) from items where item_type =:item_type",nativeQuery = true)
      int countType(@Param("item_type") String item_type);

}
