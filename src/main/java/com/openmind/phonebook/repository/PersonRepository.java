package com.openmind.phonebook.repository;

import com.openmind.phonebook.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    List<Person> findByLocationId(@Param("locationId") String locationId);

    List<Person> findByManagerId(@Param("managerId") String managerId);
}
