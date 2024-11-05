package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.AddressDto;
import com.hamitmizrak.business.mapper.AddressMapper;
import com.hamitmizrak.business.services.IAddressService;
import com.hamitmizrak.data.embeddable.AddressEntityEmbeddable;
import com.hamitmizrak.data.entity.AddressEntity;
import com.hamitmizrak.data.repository.IAddressRepository;
import com.hamitmizrak.exception._404_NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// LOMBOK
@RequiredArgsConstructor // for injection

// Asıl iş yükünü yapan Bean
@Service
public class AddressServiceImpl implements IAddressService<AddressDto, AddressEntity> {

    // FIELD INJECTION
    // 1.YOL
    /*
    @Autowired
    private IAddressRepository iAddressRepository;

    @Autowired
    private final ModelMapperBean modelMapperBean;
     */

    // CONSTRUCTOR INJECTION
    // 2.YOL
    /*
    private final IAddressRepository iAddressRepository;
    private final ModelMapperBean modelMapperBean;
    @Autowired
    public AddressServiceImpl(IAddressRepository iAddressRepository, ModelMapperBean modelMapperBean) {
        this.iAddressRepository = iAddressRepository;
        this.modelMapperBean = modelMapperBean;
    }
    */

    // LOMBOK CONSTRUCTOR INJECTION
    // 3.YOL
    private final IAddressRepository iAddressRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public AddressDto entityAddressToDto(AddressEntity addressEntity) {

        // 1.YOL
        // return modelMapperBean.getModelMapper().map(addressEntity, AddressDto.class);

        // 2.YOL
        return AddressMapper.AddressEntityToDto(addressEntity);
    }

    @Override
    public AddressEntity dtoAddressToEntity(AddressDto addressDto) {
        // 1.YOL
        // return modelMapperBean.getModelMapper().map(addressDto, AddressEntity.class);

        //  2.YOL
        return AddressMapper.AddressDtoToEntity(addressDto);
    }

    /////////////////////////////////////////////////////////////////
    // CRUD
    // CREATE
    @Transactional // create, delete, update (manipulation)
    @Override
    public AddressDto addressServiceCreate(AddressDto addressDto) {
        AddressEntity addressEntityCreate = dtoAddressToEntity(addressDto);
        addressEntityCreate = iAddressRepository.save(addressEntityCreate);
        return entityAddressToDto(addressEntityCreate);
    }

    // LIST
    @Override
    public List<AddressDto> addressServiceList() {
        return iAddressRepository.findAll()
                .stream()
                .map(AddressMapper::AddressEntityToDto)
                .collect(Collectors.toList());
    }

    // FIND BY ID
    @Override
    public AddressDto addressServiceFindById(Long id) {
        return iAddressRepository.findById(id)
                .map(AddressMapper::AddressEntityToDto)
                .orElseThrow(() -> new _404_NotFoundException(id + " nolu Address yoktur"));
    }

    // UPDATE
    @Transactional // create, delete, update (manipulation)
    @Override
    public AddressDto addressServiceUpdate(Long id, AddressDto addressDto) {
        // ID Varsa
        AddressEntity addressEntityUpdate = dtoAddressToEntity(addressServiceFindById(id));

        // Embeddable
        AddressEntityEmbeddable addressEntityEmbeddable = new AddressEntityEmbeddable();
        addressEntityEmbeddable.setZipCode(addressDto.getZipCode());
        addressEntityEmbeddable.setCity(addressDto.getCity());
        addressEntityEmbeddable.setState(addressDto.getState());
        addressEntityEmbeddable.setStreet(addressDto.getStreet());
        addressEntityEmbeddable.setDoorNumber(addressDto.getDoorNumber());
        addressEntityEmbeddable.setDescription(addressDto.getDescription());
        addressEntityUpdate=iAddressRepository.saveAndFlush(addressEntityUpdate);
        return entityAddressToDto(addressEntityUpdate);
    }

    // DELETE
    @Transactional // create, delete, update (manipulation)
    @Override
    public AddressDto addressServiceDeleteById(Long id) {
        // ID Varsa
        AddressEntity addressEntityDelete = dtoAddressToEntity(addressServiceFindById(id));
        iAddressRepository.delete(addressEntityDelete);
        return entityAddressToDto(addressEntityDelete);
    }

    /////////////////////////////////////////////////
    // SORTING / PAGINTION
    // PAGINATION
    @Override
    // Page, Pageable : org.springframework.data.domain;
    public Page<AddressEntity> addressServicePagination(int currentPage, int pageSize) {
        Pageable pageable= PageRequest.of(currentPage, pageSize);
        Page<AddressEntity> addressEntityPage = iAddressRepository.findAll(pageable);
        return addressEntityPage;
    }

    // SORTING
    @Override
    public List<AddressEntity> addressServiceAllSortedBy(String sortedBy) {
        return List.of();
    }

    // SORTING
    @Override
    public List<AddressEntity> addressServiceAllSortedByCityAsc() {
        return List.of();
    }

    // SORTING
    @Override
    public List<AddressEntity> addressServiceAllSortedByCityDesc() {
        return List.of();
    }

}
