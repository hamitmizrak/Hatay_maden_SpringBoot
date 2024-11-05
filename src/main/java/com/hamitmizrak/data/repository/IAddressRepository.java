package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CrudRepository<AddressEntity, Long>
// PagingAndSortingRepository<AddressEntity, Long>

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {
    // Delivered Query
    // JPQL
    // Native Query
}
