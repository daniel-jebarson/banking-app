package net.bankapp.banking.service.Impl;

import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.Mapper.PersonMapper;
import net.bankapp.banking.dto.Person.PersonCreateDto;
import net.bankapp.banking.dto.Person.PersonDto;
import net.bankapp.banking.entity.Person;
import net.bankapp.banking.repository.PersonRepo;
import net.bankapp.banking.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;

    PersonServiceImpl(PersonRepo personRepo){
        this.personRepo=personRepo;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons=personRepo.findAll();
        return persons.stream()
                .map(PersonMapper::personToPersonDto) // Use method reference for clarity
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getPersonById(Integer id) {
        Person per=personRepo.findById(id).orElse(null);
        return per!=null?PersonMapper.personToPersonDto(per):null;
    }

    @Override
    public PersonDto savePerson(PersonCreateDto person) {
        Person p=PersonMapper.personCreateDToToPerson(person);
        Person newPerson=personRepo.save(p);
        return PersonMapper.personToPersonDto(newPerson);
    }

    @Override
    public void deletePerson(Integer id) throws CustomException {
        try{
            PersonDto p=getPersonById(id);
            if(p==null){
                throw new Exception("Invalid id. Unable to delete user");
            }
            personRepo.deleteById(id);
        }catch (Exception e){
            throw new CustomException(400,e.getMessage());
        }
    }
}
