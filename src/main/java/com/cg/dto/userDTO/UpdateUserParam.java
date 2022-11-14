package com.cg.dto.userDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UpdateUserParam {

    private Long id;

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private String avatarUrl;


 }
