package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.AddressDto;
import com.hamitmizrak.business.services.IAddressService;
import com.hamitmizrak.controller.api.IAddressApi;
import com.hamitmizrak.error.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

// LOMBOK
@RequiredArgsConstructor
@Log4j2


// API: Dış dünyaya açılan kapı
@RestController
@CrossOrigin // Backendten giden veriyi yakalacak frontend için farklı portlara izin vermek
@RequestMapping("/api/address")
public class AddressApiImpl implements IAddressApi<AddressDto> {

    // INJECTION
    private final IAddressService iAddressService;
    private final MessageSource messageSource;


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

    // DELETE  API (Address)
    // http://localhost:4444/api/address/delete/%20
    // http://localhost:4444/api/address/delete/0
    // http://localhost:4444/api/address/delete/-1
    // http://localhost:4444/api/address/delete/44
    // http://localhost:4444/api/address/delete/1
    // DELETE BY ID
    // @DeleteMapping("/delete") =>
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> addressApiDeleteById(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("API: 404 NOT FOUND");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("API: 400 BAD REQUEST");
            String message = messageSource.getMessage("address.delete.badRequest", null, LocaleContextHolder.getLocale());
            ApiResult apiResult = ApiResult.builder()
                    .path("http://localhost:4444/api/address/delete/0")
                    .message(message)
                    .error("BadRequest")
                    .status(400)
                    .build();
            System.out.println(message);
            return ResponseEntity.badRequest().body(apiResult);
        } else if (id < 0) {
            log.error("API: 401 UNAUTHORIZED");
            String message = messageSource.getMessage("address.delete.unauthorized", null,  LocaleContextHolder.getLocale()); //Locale.getDefault()
            ApiResult apiResult = ApiResult.builder()
                    .path("http://localhost:4444/api/address/delete/-1")
                    .message(message)
                    .error("Unauthorized")
                    .status(400)
                    .build();
            return ResponseEntity.status(401).body(apiResult);
        }
        return ResponseEntity.ok(iAddressService.addressServiceDeleteById(id));
    }


    ////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public ResponseEntity<Page<?>> addressServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<List<?>> addressApiAllSortedBy(String sortedBy) {
        return null;
    }

    @Override
    public ResponseEntity<List<?>> addressApiAllSortedByCityAsc() {
        return null;
    }

    @Override
    public ResponseEntity<List<?>> addressApiAllSortedByCityDesc() {
        return null;
    }


} //end AddressApiImpl
