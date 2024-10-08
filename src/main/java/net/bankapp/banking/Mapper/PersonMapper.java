package net.bankapp.banking.Mapper;

import net.bankapp.banking.dto.Person.PersonCreateDto;
import net.bankapp.banking.dto.Person.PersonDto;
import net.bankapp.banking.entity.Person;

public class PersonMapper {
    public static Person personDtoToPerson(PersonDto personDto){
        return new Person(
                personDto.getFname(),
                personDto.getLname(),
                personDto.getEmail(),
                personDto.getDob(),
                personDto.getNumber(),
                personDto.getAddress()
        );
    }

    public static PersonCreateDto personToPersonCreateDto(Person person){
        return new PersonCreateDto(
                person.getLastName(),
                person.getFirstName(),
                person.getDateOfBirth(),
                person.getEmail(),
                person.getPhoneNumber(),
                person.getAddress()
        );
    }

    public static PersonDto personToPersonDto(Person person){
        return new PersonDto(
                person.getPersonId(),
                person.getLastName(),
                person.getFirstName(),
                person.getDateOfBirth(),
                person.getEmail(),
                person.getPhoneNumber(),
                person.getAddress()
        );
    }

    public static Person personCreateDToToPerson(PersonCreateDto person){
        return new Person(
                person.getLname(),
                person.getFname(),
                person.getEmail(),
                person.getDob(),
                person.getNumber(),
                person.getAddress()
        );
    }
}
