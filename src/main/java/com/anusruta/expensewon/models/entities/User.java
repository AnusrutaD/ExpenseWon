package com.anusruta.expensewon.models.entities;

import com.anusruta.expensewon.models.dtos.GetUserResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "USERS")
public class User extends BaseModel{
    private String name;
    private String phone;
    private String email;
    private String hashedPassword;

    public GetUserResponse toResponse() {
        return GetUserResponse.builder()
                .name(this.name)
                .email(this.email)
                .phone(this.phone)
                .build();
    }
}
