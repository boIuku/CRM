package com.example.demo.service;



import com.example.demo.entity.Persons;

import java.util.List;
import java.util.Optional;

public interface CustomersService {

    Optional<Persons> findById(Long Id);

    List<Persons> findAll();

    Long savePerson(Persons persons);

    void deletePersons(Persons persons);

}
