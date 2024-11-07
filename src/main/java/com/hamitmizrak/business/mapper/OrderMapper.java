package com.hamitmizrak.business.mapper;

import com.hamitmizrak.business.dto.OrderDto;
import com.hamitmizrak.data.entity.OrderEntity;

public class OrderMapper {

    // Customer Entity To Dto
    public static OrderDto OrderEntityToDto(OrderEntity orderEntity) {
        // Instance (CustomerDto)
        OrderDto orderDto = new OrderDto();

        // ID
        orderDto.setId(orderEntity.getId());
        orderDto.setName(orderEntity.getName());
        orderDto.setPrice(orderEntity.getPrice());

        // DİKKAT: Composition (Order(N) Customer(1))

        return orderDto;
    }

    // Customer Dto To Entity
    public static OrderEntity OrderDtoToEntity(OrderDto productDto) {
        // Instance (CustomerDto)
        OrderEntity orderEntity = new OrderEntity();

        // ID
        orderEntity.setId(productDto.getId());
        orderEntity.setName(productDto.getName());
        orderEntity.setPrice(productDto.getPrice());

        // DİKKAT: Composition (Order(N) Customer(1))
        return orderEntity;
    }
}
