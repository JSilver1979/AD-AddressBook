package ru.jsilver.itHelper.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jsilver.itHelper.dto.DepartmentDto;
import ru.jsilver.itHelper.dto.OrgUnitDto;
import ru.jsilver.itHelper.dto.PersonUserDto;
import ru.jsilver.itHelper.services.DepartmentService;
import ru.jsilver.itHelper.services.OrgUnitService;
import ru.jsilver.itHelper.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final OrgUnitService orgUnitService;
    private final DepartmentService depService;

    @GetMapping("/list_all")
    public List<PersonUserDto> getDepPersons() {
        return personService.getUserList();
    }

    @GetMapping("/units")
    public List<OrgUnitDto> getUnitsList() {
        return orgUnitService.getAllUnits();
    }

    @GetMapping("/deps")
    public List<DepartmentDto> getDeps() {
        return depService.getDeps();
    }
}
