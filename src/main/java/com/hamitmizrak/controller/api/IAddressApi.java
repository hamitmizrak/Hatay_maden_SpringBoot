package com.hamitmizrak.controller.api;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

// D: Dto
public interface IAddressApi<D> {

    // CRUD
    // CREATE (ADDRESS)
    public ResponseEntity<?>  addressApiCreate(D d);

    // LIST (ADDRESS)
    public ResponseEntity<List<D>> addressApiList();

    // FIND (ADDRESS)
    public ResponseEntity<?> addressApiFindById(Long id);

    // UPDATE (ADDRESS)
    public ResponseEntity<?> addressApiUpdate(Long id, D d);

    // DELETE  (ADDRESS)
    public ResponseEntity<?> addressApiDeleteById(Long id);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PAGINATION
    public ResponseEntity<Page<?>> addressServicePagination(int currentPage, int pageSize);

    // SORTING
    // Adres Entityden belirli sutununa göre Sıramalama
    public ResponseEntity<List<?>> addressApiAllSortedBy(String sortedBy);

    // SORTING ASC
    // Default Olarak Addres Entityden Şehire göre Küçükten Büyüğe Doğru Sıralama
    public ResponseEntity<List<?>> addressApiAllSortedByCityAsc();

    // SORTING DESC
    // Default Olarak Addres Entityden Şehire göre Büyükten Küçüğe Doğru Sıralama
    public ResponseEntity<List<?>> addressApiAllSortedByCityDesc();



}
