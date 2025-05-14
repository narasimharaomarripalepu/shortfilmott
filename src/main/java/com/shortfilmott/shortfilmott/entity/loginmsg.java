package com.shortfilmott.shortfilmott.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class loginmsg {
    private Long user_id;
    private String msg;
}
