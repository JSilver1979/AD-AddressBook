package ru.jsilver.itHelper.data.mappers;

import org.springframework.ldap.core.AttributesMapper;
import ru.jsilver.itHelper.data.Person;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

public class PersonAttributesMapper implements AttributesMapper<Person> {
    public Person mapFromAttributes(Attributes attrs) throws NamingException {
        Person person = new Person();
        person.setFullName((String) attrs.get("cn").get());

        String[] names = person.getFullName().trim().split(" ",3);

        if ((names[1] != null) || !names[1].isEmpty()) {
            person.setName(names[1]);
        }
        if ((names[0] != null) || !names[0].isEmpty()) {
            person.setSurname(names[0]);
        }
        if (names.length > 2) {
            if ((names[2] != null) || !names[2].isEmpty()) {
                person.setPatronymic(names[2]);
            }
        }

        Attribute dn = attrs.get("distinguishedName");
        if (dn != null) {
            person.setDn((String) dn.get());
        }

        Attribute weight = attrs.get("employeeNumber");
        if (weight != null) {
            person.setWeight((String) weight.get());
        }

        Attribute birthday = attrs.get("employeeType");
        if (birthday != null) {
            String[] data = birthday.get().toString().trim().split("\\.", 2);
            person.setBirthMonth(data[0]);
            person.setBirthDay(data[1]);
        } else {
            person.setBirthMonth("");
            person.setBirthDay("");
        }

        Attribute ipPhone = attrs.get("ipPhone");
        if (ipPhone != null) {
            person.setIpPhone((String) ipPhone.get());
        }

        Attribute mail = attrs.get("mail");
        if (mail != null) {
            person.setMail((String) mail.get());
        }

        Attribute mobilePhone = attrs.get("mobile");
        if (mobilePhone != null) {
            person.setMobilePhone((String) mobilePhone.get());
        }

        Attribute office = attrs.get("physicalDeliveryOfficeName");
        if (office != null) {
            person.setOffice((String) office.get());
        }

        Attribute login = attrs.get("sAMAccountName");
        if (login != null) {
            person.setLogin((String) login.get());
        }

        Attribute streetAddress = attrs.get("streetAddress");
        if (streetAddress != null) {
            person.setStreetAddress((String) streetAddress.get());
        }

        Attribute workNumber = attrs.get("telephoneNumber");
        if (workNumber != null) {
            person.setWorkNumber((String) workNumber.get());
        }

        Attribute title = attrs.get("title");
        if (title != null) {
            person.setTitle((String) title.get());
        }

        Attribute department = attrs.get("department");
        if (department != null) {
            person.setDepartment((String) department.get());
        }

        return person;
    }
}

