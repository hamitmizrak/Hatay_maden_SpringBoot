package com.hamitmizrak.runner;

import com.hamitmizrak.business.dto.AddressDto;
import com.hamitmizrak.business.dto.CustomerDto;
import com.hamitmizrak.business.services.IAddressService;
import com.hamitmizrak.business.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// DATA SET
@Component

// Birden fazla CommandLineRunner varsa, hangi sırayla çalışacaklarını belirlemek için @Order anotasyonu kullanılabilir:
@Order(1)
public class _1_ProjectDataSet implements CommandLineRunner {

    // Injection
    private final IAddressService iAddressService;
    private final ICustomerService iCustomerService;

    // AddressDto List Save
    private List<AddressDto> addressSave(){
        List<AddressDto> addressDtoList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            AddressDto addressDto = new AddressDto();
            addressDto.setCity("Hatay "+i);
            addressDto.setDescription("tanımlama "+i);
            addressDto.setStreet("cadde "+i);
            addressDto.setState("state "+i);
            addressDto.setZipCode("zip code "+i);
            addressDto.setDoorNumber("door number "+i);
            addressDto.setAddressQrCode(UUID.randomUUID().toString());
            iAddressService.addressServiceCreate(addressDto);
            addressDtoList.add(addressDto);
        }
        return addressDtoList;
    }

    // Address Save
    private AddressDto saveAddress(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCity("Hatay ");
        addressDto.setDescription("tanımlama ");
        addressDto.setStreet("cadde ");
        addressDto.setState("state ");
        addressDto.setZipCode("zip code ");
        addressDto.setDoorNumber("door number ");
        addressDto.setAddressQrCode(UUID.randomUUID().toString());
        return addressDto;
    }

    private CustomerDto saveCustomer(){

        // Address Dto Save
        AddressDto addressDto = saveAddress();

        // Customer Dto Save
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("Hamit");
        customerDto.setLastName("Mızrak");
        customerDto.setNotes("Notes");

        // Composition
        customerDto.setAddressDto(addressDto);

        // Save
        iCustomerService.customerServiceCreate(customerDto);
        System.out.println(customerDto);
        return customerDto;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Project Data set -1 ");
        log.info("Project Data set -1 ");
        //addressSave();
        saveCustomer();
    }
}
