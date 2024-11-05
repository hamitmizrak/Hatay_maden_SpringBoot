package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// ENTITY
@Entity
@Table(name = "adress")

// Address(1) - Customer(1)
public class AddressEntity {

    // FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // DOOR NUMBER
    @Column(name = "door_number")
    private String doorNumber;

    // STREET
    private String street;

    // CITY
    @Column(name = "city")
    private String city;

    // STATE
    @Column(name = "state")
    private String state;

    // ZIP CODE
    @Column(name = "zip_code")
    private String zipCode;

    // ADDRESS QR CODE
    @Column(name = "address_qr_code")
    private String addressQrCode;

    // DESCRIPTION
    @Column(name = "description")
    private String description;
} //end  AddressEntity
