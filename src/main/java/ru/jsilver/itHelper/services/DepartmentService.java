package ru.jsilver.itHelper.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jsilver.itHelper.data.OrgUnit;
import ru.jsilver.itHelper.dto.DepartmentDto;
import ru.jsilver.itHelper.dto.OrgUnitDto;
import ru.jsilver.itHelper.dto.PersonUserDto;
import ru.jsilver.itHelper.repositories.OrgUnitRepository;
import ru.jsilver.itHelper.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final OrgUnitRepository ouRepo;
    private final PersonRepository personRepo;

    public List<DepartmentDto> getDeps() {
        List<DepartmentDto> depList = new ArrayList<>();
        List<OrgUnitDto> unitsList = ouRepo.getUnits()
                .stream().sorted(Comparator.comparing(OrgUnit::getName))
                .map(orgUnit -> new OrgUnitDto(orgUnit))
                .collect(Collectors.toList());
        for (int i = 0; i < unitsList.size(); i++) {
            List<PersonUserDto> personsList = personRepo.getAllFromOU(unitsList.get(i).getName())
                    .stream()
                    .map(person -> new PersonUserDto(person))
                    .collect(Collectors.toList());
            if (!personsList.isEmpty()) {
                depList.add(new DepartmentDto(unitsList.get(i).getName(), personsList));
            }
        }
        return depList;
    }
}
