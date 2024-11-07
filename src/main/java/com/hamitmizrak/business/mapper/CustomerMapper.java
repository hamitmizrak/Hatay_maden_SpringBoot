package com.hamitmizrak.business.mapper;

import com.hamitmizrak.business.dto.CustomerDto;
import com.hamitmizrak.data.entity.CustomerEntity;

public class CustomerMapper {

    // Customer Entity To Dto
    public static CustomerDto CustomerEntityToDto(CustomerEntity customerEntity) {
        // Instance (CustomerDto)
        CustomerDto customerDto = new CustomerDto();

        // ID
        customerDto.setId(customerEntity.getId());
        customerDto.setFirstName(customerEntity.getFirstName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setNotes(customerEntity.getNotes());

        // DİKKAT: Composition (Customer(1) Adres(1))

        if (customerEntity.getAddressCustomerEntity() != null) {
            customerDto.setAddressDto(AddressMapper.AddressEntityToDto(customerEntity.getAddressCustomerEntity()));
        } else {
            System.out.println("Customer(1) Adres(1) Customer Composition Adress null");
        }

        return customerDto;
    }

    // Customer Dto To Entity
    public static CustomerEntity CustomerDtoToEntity(CustomerDto customerDto) {
        // Instance (CustomerDto)
        CustomerEntity customerEntity = new CustomerEntity();

        // ID
        customerEntity.setId(customerDto.getId());
        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setNotes(customerDto.getNotes());

        // DİKKAT: Composition (Customer(1) Adres(1))
        if(customerDto.getAddressDto() != null) {
            customerEntity.setAddressCustomerEntity(AddressMapper.AddressDtoToEntity(customerDto.getAddressDto()));
        }
        return customerEntity;
    }
}
