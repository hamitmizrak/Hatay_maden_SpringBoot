package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.AddressDto;
import com.hamitmizrak.business.services.IAddressService;
import com.hamitmizrak.controller.api.IAddressApi;
import com.hamitmizrak.error.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor


// API: Dıi dünyaya açılan kapı
@RestController
@CrossOrigin // Backendten giden veriyi yakalacak frontend için farklı portlara izin vermek
@RequestMapping("/api/address")
public class AddressApiImpl implements IAddressApi<AddressDto> {

    // INJECTION
    private final IAddressService addressService;


    // http://localhost:4444/api/address/create
    // CREATE (ADDRESS)
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> addressApiCreate( @Valid @RequestBody AddressDto addressDto) {
        return null;
    }

    // http://localhost:4444/api/address/list
    // LIST
    @GetMapping(value="/list")
    @Override
    public ResponseEntity<List<AddressDto>> addressApiList() {

        return null;
    }

    // FIND
    @GetMapping("/find")
    @Override
    public ResponseEntity<?> addressApiFindById(Long id) {
        return null;
    }

    // UPDATE
    @PutMapping("/update")
    @Override
    public ResponseEntity<?> addressApiUpdate(Long id, @Valid @RequestBody AddressDto addressDto) {
        return null;
    }

    // DELETE BY ID
    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<?> addressApiDeleteById(Long id) {
        ApiResult apiResult= ApiResult.builder()
                .status(401)
                .message("Unauthorized")
                .error("error")
                .path("/api/address/delete")
                .build();
        return null;
    }

} //end AddressApiImpl