package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.AddressDto;
import com.hamitmizrak.business.services.IAddressService;
import com.hamitmizrak.controller.api.IAddressApi;
import com.hamitmizrak.error.ApiResult;
import com.hamitmizrak.exception._400_BadRequestException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 1xx: Information
// 2xx: Success
// 3xx: Direction
// 4xx: Client Error
// 5xx: Server Error

// LOMBOK
@RequiredArgsConstructor

// API: Dıi dünyaya açılan kapı
@RestController
@CrossOrigin // Backendten giden veriyi yakalacak frontend için farklı portlara izin vermek
@RequestMapping("/api/address")
public class AddressApiImpl implements IAddressApi<AddressDto> {

    // INJECTION
    private final IAddressService iAddressService;

    // Api Result
    private ApiResult apiResult;

    // http://localhost:4444/api/address/create
    // CREATE (ADDRESS)
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> addressApiCreate(@Valid @RequestBody AddressDto addressDto) {
        AddressDto addressDtoCreate = (AddressDto) iAddressService.addressServiceCreate(addressDto);
        // return ResponseEntity.status(200).body(addressDtoCreate);
        // return ResponseEntity.status(HttpStatus.OK).body(addressDtoCreate);
        // return new ResponseEntity<>(addressDtoCreate, HttpStatus.CREATED);
        // return ResponseEntity.ok().body(addressDtoCreate);
        return ResponseEntity.ok(addressDtoCreate);
    }

    // http://localhost:4444/api/address/list
    // LIST
    @GetMapping(value = "/list")
    @Override
    public ResponseEntity<List<AddressDto>> addressApiList() {
        List<AddressDto> addressDtoList = iAddressService.addressServiceList();
        // Stream
        return ResponseEntity.ok(addressDtoList);
    }

    // http://localhost:4444/api/address/find
    // http://localhost:4444/api/address/find/0
    // http://localhost:4444/api/address/find/-1
    // http://localhost:4444/api/address/find/%20%
    // http://localhost:4444/api/address/find/44
    // @PathVariable Long id
    // @PathVariable(name="id") Long id, @PathVariable(name="id") Long id
    // FIND
    @GetMapping({"/find/", "/find/{id}"})
    @Override
    public ResponseEntity<?> addressApiFindById(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            throw new NullPointerException("Null Pointer Exception");
        } else if (id == 0) {
            throw new _400_BadRequestException("Bad Request: Kötü istek");
        } else if (id < 0) {
            apiResult = new ApiResult();
            apiResult.setError("unAuthorized: Yetkisiz Giriş");
            apiResult.setPath("/api/address/find");
            apiResult.setStatus(HttpStatus.UNAUTHORIZED.value());
            apiResult.setMessage("Unauthorized");
            return ResponseEntity.ok(apiResult);
        }

        // Yukarıdakilerden herhangi bir sıkıntı söz konusu değilse
        AddressDto addressDtoFind = (AddressDto) iAddressService.addressServiceFindById(id);
        return ResponseEntity.ok(addressDtoFind);
    }

    // UPDATE
    @PutMapping({"/update/", "/update/{id}"})
    @Override
    public ResponseEntity<?> addressApiUpdate(
            @PathVariable(name = "id", required = false) Long id,
            @Valid @RequestBody AddressDto addressDto) {
        return  ResponseEntity.ok(iAddressService.addressServiceUpdate(id, addressDto));
    }

    // DELETE BY ID
    @DeleteMapping({"/delete/", "/delete/{id}"})
    @Override
    public ResponseEntity<?> addressApiDeleteById(@PathVariable(name = "id", required = false)  Long id) {
        return ResponseEntity.ok(iAddressService.addressServiceDeleteById(id));
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // PAGING AND SORTING
    @Override
    public ResponseEntity<Page<?>> addressServicePagination(int currentPage, int pageSize) {
        return  ResponseEntity.ok(iAddressService.addressServicePagination(currentPage, pageSize));
    }

    @Override
    public ResponseEntity<List<?>> addressServiceAllSortedBy(String sortedBy) {
        return ResponseEntity.ok(iAddressService.addressServiceAllSortedBy(sortedBy));
    }

    @Override
    public ResponseEntity<List<?>> addressServiceAllSortedByCityAsc() {
        return ResponseEntity.ok(iAddressService.addressServiceAllSortedByCityAsc());
    }

    @Override
    public ResponseEntity<List<?>> addressServiceAllSortedByCityDesc() {
        return ResponseEntity.ok(iAddressService.addressServiceAllSortedByCityDesc());
    }

} //end AddressApiImpl