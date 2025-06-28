package com.anusruta.expensewon.models.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.util.Date;

@Getter
@MappedSuperclass
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
