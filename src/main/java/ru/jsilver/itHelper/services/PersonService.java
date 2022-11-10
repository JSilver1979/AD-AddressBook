package ru.jsilver.itHelper.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jsilver.itHelper.data.Person;
import ru.jsilver.itHelper.dto.PersonUserDto;
import ru.jsilver.itHelper.repositories.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<PersonUserDto> getUserList() {
        List<PersonUserDto> personsList = repository.getAll()
                .stream().sorted(Comparator.comparing(Person::getFullName))
                .map(person -> new PersonUserDto(person))
                .collect(Collectors.toList());
        return personsList;
    }

    public List<PersonUserDto> getUsersFromOU(String ou) {
        List<PersonUserDto> personsList = repository.getAllFromOU(ou)
                .stream()
                .map(person -> new PersonUserDto(person))
                .collect(Collectors.toList());
        return personsList;
    }
}
