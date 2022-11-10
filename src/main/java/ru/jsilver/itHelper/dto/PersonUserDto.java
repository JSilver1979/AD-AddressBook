package ru.jsilver.itHelper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.jsilver.itHelper.data.Person;

@Data
@NoArgsConstructor
public class PersonUserDto {
    private String fullName;
    private String title;
    private String department;
    private String address;
    private String office;
    private String ipPhone;
    private String mobilePhone;
    private String mail;
    private String birthday;

    public PersonUserDto(Person person) {
        this.fullName = person.getFullName();
        this.title = person.getTitle();
        this.department = person.getDepartment();
        this.address = person.getStreetAddress();
        this.office = person.getOffice();
        this.ipPhone = person.getIpPhone();
        this.mobilePhone = person.getMobilePhone();
        this.mail = person.getMail();
        this.birthday = person.getBirthMonth() + " " + person.getBirthDay();
    }
}
