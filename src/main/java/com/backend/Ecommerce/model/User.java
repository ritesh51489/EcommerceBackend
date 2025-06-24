package com.backend.Ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    String email;
    String username;
    String address;
    String mobileno;
    boolean masterUser;
    String password;


}
