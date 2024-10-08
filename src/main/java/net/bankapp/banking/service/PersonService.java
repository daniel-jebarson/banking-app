package net.bankapp.banking.service;

import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.dto.Person.PersonCreateDto;
import net.bankapp.banking.dto.Person.PersonDto;
import net.bankapp.banking.entity.Person;

import java.util.List;

public interface PersonService {
    public List<PersonDto> getAllPersons();

    public PersonDto getPersonById(Integer id);

    public PersonDto savePerson(PersonCreateDto person);

    public void deletePerson(Integer id) throws CustomException;

}
