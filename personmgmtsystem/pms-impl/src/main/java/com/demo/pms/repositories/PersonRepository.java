package com.demo.pms.repositories;

import com.demo.pms.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PersonRepository extends JpaRepository<PersonEntity, String>, QuerydslPredicateExecutor<PersonEntity> {
}
