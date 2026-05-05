package com.api.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.demo.models.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
