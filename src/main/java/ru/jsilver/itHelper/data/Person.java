package ru.jsilver.itHelper.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

    private String fullName;
    private String name;
    private String surname;
    private String patronymic;

    private String mail;
    private String dn;

    private String weight;
    private String birthMonth;
    private String birthDay;
    private String ipPhone;
    private String mobilePhone;
    private String office;
    private String login;
    private String streetAddress;
    private String workNumber;
    private String title;
    private String department;

}
