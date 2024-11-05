package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.AddressDto;
import org.springframework.data.domain.Page;
import java.util.List;

// D: Dto
// E: Entity
public interface IAddressService<D, E> {

    // Model Mapper
    public D entityAddressToDto(E e);

    public E dtoAddressToEntity(D d);

    /////////////////////////////////////////////////
    // CRUD
    // CREATE (ADDRESS)
    public D addressServiceCreate(D d);

    // LIST (ADDRESS)
    public List<D> addressServiceList();

    // FIND (ADDRESS)
    public D addressServiceFindById(Long id);

    // UPDATE (ADDRESS)
    public D addressServiceUpdate(Long id, D d);

    // DELETE  (ADDRESS)
    public D addressServiceDeleteById(Long id);

    /////////////////////////////////////////////////
    // SORTING / PAGINTION
    //  PAGINTION
    public Page<E> addressServicePagination(int currentPage, int pageSize);

    // SORTING
    // Address Entity içindeki herhangibi bir olan kolana göre sıralama
    public List<E> addressServiceAllSortedBy(String sortedBy);

    // SORTING ASC
    // Address Entity içindeki city olan özel bir alana göre sıralama
    public List<E> addressServiceAllSortedByCityAsc();

    // SORTING DESC
    public List<E> addressServiceAllSortedByCityDesc();
}