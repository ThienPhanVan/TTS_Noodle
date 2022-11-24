package com.cg.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ListCreatedBy {

    private Long createdBy;

    private String name;

}