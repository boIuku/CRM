package com.example.demo.service;

import com.example.demo.entity.Persons;
import com.example.demo.repository.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImp implements CustomersService{

    private final ContactPersonRepository contactPersonRepository;
    @Autowired
    CustomersServiceImp(ContactPersonRepository contactPersonRepository) {
        this.contactPersonRepository = contactPersonRepository;
    }

    @Override
    public Optional<Persons> findById(Long id) {
        return contactPersonRepository.findById(id);
    }

    @Override
    public List<Persons> findAll() {
        return contactPersonRepository.findAll();
    }

    @Override
    public Long savePerson(Persons persons) {
        contactPersonRepository.save(persons);
        return persons.getId();
    }

    @Override
    public void deletePersons(Persons persons) {
        contactPersonRepository.delete(persons);
    }
}
