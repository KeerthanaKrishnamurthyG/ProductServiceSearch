package com.app.ecom.ecommercedemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

/**
 * BaseModel
 */
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
public class BaseModel {
     @Id
     private long id;
}  