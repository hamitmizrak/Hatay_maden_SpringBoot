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
        if(orderEntity.getCustomerOrderEntity()!=null){
            orderDto.setCustomerDto(CustomerMapper.CustomerEntityToDto(orderEntity.getCustomerOrderEntity()));
        }
        return orderDto;
    }

    // Customer Dto To Entity
    public static OrderEntity OrderDtoToEntity(OrderDto orderDto) {
        // Instance (CustomerDto)
        OrderEntity orderEntity = new OrderEntity();

        // ID
        orderEntity.setId(orderDto.getId());
        orderEntity.setName(orderDto.getName());
        orderEntity.setPrice(orderDto.getPrice());

        // DİKKAT: Composition (Order(N) - Customer(1))
        if(orderDto.getCustomerDto()!=null){
            orderEntity.setCustomerOrderEntity(CustomerMapper.CustomerDtoToEntity(orderDto.getCustomerDto()));
        }

        // DİKKAT: Composition (Order(N) - Product(M))
        return orderEntity;
    }
}
