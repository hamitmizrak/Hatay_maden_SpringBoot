package com.hamitmizrak.annotation;

import com.hamitmizrak.data.entity.AddressEntity;
import com.hamitmizrak.data.repository.IAddressRepository;
import com.hamitmizrak.exception._404_NotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

// LOMBOK
@RequiredArgsConstructor

// Address Tablosundaki AddressQrCode eğer ilgili kayıt varsa;
// eklemesin ve hata olarak benzersiz bir address oluştururun
public class AddressValidQrCode implements ConstraintValidator<AddressUniqueQrCode,String> {

    // INJECTION
    private final IAddressRepository iAddressRepository;

    @Override
    public boolean isValid(String addressQrCode, ConstraintValidatorContext constraintValidatorContext) {
        String findQrCode= addressQrCode+ " Böyle bir qr code yoktur ";
        // 1.YOL
      AddressEntity addressEntity= iAddressRepository
              .findAddressEntityByAddressEntityEmbeddable_AddressQrCode(addressQrCode)
              .orElseThrow( () -> new _404_NotFoundException(findQrCode));
        // 2.YOL
        return false;
    }
}
