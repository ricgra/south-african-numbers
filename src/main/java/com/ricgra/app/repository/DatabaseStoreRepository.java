package com.ricgra.app.repository;

import com.ricgra.app.entity.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseStoreRepository extends JpaRepository<PhoneNumberEntity, Integer> {
}
