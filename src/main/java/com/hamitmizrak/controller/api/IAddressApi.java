package com.hamitmizrak.controller.api;

import org.springframework.http.ResponseEntity;
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
}
