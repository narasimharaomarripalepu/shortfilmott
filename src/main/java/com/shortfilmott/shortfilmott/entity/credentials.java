package com.shortfilmott.shortfilmott.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class credentials {
    private String user_email;
    private String password;
}
