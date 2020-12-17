package com.bhp.catalog.beans;/*my name is udi sasson and the date is 29/11/2020 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name= "items")
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


	@CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDate;

	@UpdateTimestamp
    private Timestamp lastModifiedDate;

	private String name;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;


    }
