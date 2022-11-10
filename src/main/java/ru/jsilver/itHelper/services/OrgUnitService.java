package ru.jsilver.itHelper.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jsilver.itHelper.dto.OrgUnitDto;
import ru.jsilver.itHelper.repositories.OrgUnitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrgUnitService {
    private final OrgUnitRepository ouRepo;

    public List<OrgUnitDto> getAllUnits() {
        List<OrgUnitDto> unitsList = ouRepo.getUnits()
                .stream()
                .map(orgUnit -> new OrgUnitDto(orgUnit))
                .collect(Collectors.toList());
        return unitsList;
    }
}
