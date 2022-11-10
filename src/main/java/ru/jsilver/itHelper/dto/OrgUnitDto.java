package ru.jsilver.itHelper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.jsilver.itHelper.data.OrgUnit;

@Data
@NoArgsConstructor
public class OrgUnitDto {
    private String name;

    public OrgUnitDto(OrgUnit orgUnit) {
        this.name = orgUnit.getName();
    }
}
