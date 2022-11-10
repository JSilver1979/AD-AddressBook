package ru.jsilver.itHelper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentDto {
    private String depName;
    private List<PersonUserDto> personsInDep;
}
