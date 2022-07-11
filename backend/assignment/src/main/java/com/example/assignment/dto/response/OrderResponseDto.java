package com.example.assignment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDto {
    private int orderId;
    private int accId;
    private List<CartItemResponseDto> products;
    private String status;
    private Date createDate;
    private Date updateDate;


}
