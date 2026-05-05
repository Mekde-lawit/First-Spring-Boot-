package com.api.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.demo.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
