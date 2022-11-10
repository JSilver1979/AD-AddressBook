package ru.jsilver.itHelper.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Repository;
import ru.jsilver.itHelper.data.Person;
import ru.jsilver.itHelper.data.mappers.PersonAttributesMapper;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Repository
public class PersonRepository {

    @Value("${userbase}")
    private String userbase;

    private final LdapTemplate ldapTemplate;

    public PersonRepository(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public List<Person> getPersonsByMail(String mail) {
        return ldapTemplate.search(query().base(userbase)
                .where("objectclass").is("person")
                .and("mail").like("*" + mail + "*"),
                new PersonAttributesMapper());
    }

    public List<Person> getAll() {
        return ldapTemplate.search(query().base(userbase)
                .where("objectclass").is("person"), new PersonAttributesMapper());
    }

    public Person getOne(String login) {
        return ldapTemplate.search(query()
                .base("OU=Users-AC,DC=ac,DC=dzm")
                .where("objectclass").is("person")
                .and("sAMAccountName").like("*" + login + "*"),
                new PersonAttributesMapper()).stream().findFirst().orElseThrow();
    }

    public List<Person> getAllFromOU(String ou) {
        return ldapTemplate.search(query()
                .base("OU=" + ou + "," + userbase)
                .where("objectclass").is("person"), new PersonAttributesMapper());
    }
}
