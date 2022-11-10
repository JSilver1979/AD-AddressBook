package ru.jsilver.itHelper.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.SearchScope;
import org.springframework.stereotype.Repository;
import ru.jsilver.itHelper.data.OrgUnit;
import ru.jsilver.itHelper.data.mappers.OrgUnitAttributesMapper;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;

@Repository
public class OrgUnitRepository {

    @Value("${userbase}")
    private String userbase;

    private final LdapTemplate ldapTemplate;

    public OrgUnitRepository(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public List<OrgUnit> getUnits() {
        return ldapTemplate.search(query().base(userbase)
                .searchScope(SearchScope.ONELEVEL)
                .where("objectclass").is("organizationalUnit"), new OrgUnitAttributesMapper());
    }
}
