package net.bankapp.banking.controller;


import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.Error.ErrorResponse;
import net.bankapp.banking.Mapper.ErrorMapper;
import net.bankapp.banking.dto.Person.PersonCreateDto;
import net.bankapp.banking.dto.Person.PersonDto;
import net.bankapp.banking.service.Impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>>  getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Integer id) {
        PersonDto personDto= personService.getPersonById(id);
        if(personDto!=null){
            return new ResponseEntity<>(personDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(404,"Person with id "+id+" not found!!!"),HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody PersonCreateDto person) {
        try{
           PersonDto newPerson=personService.savePerson(person);
           return new ResponseEntity<>(newPerson,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(500,"Unable to save the person details"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer id) {
        try{
            personService.deletePerson(id);
            return new ResponseEntity<>("Deleted successfully!!!",HttpStatus.OK);
        }catch (CustomException e){
            return new ResponseEntity<>(ErrorMapper.CustomExceptionToErrorResponse(e),HttpStatus.BAD_REQUEST);
        }
    }
}
