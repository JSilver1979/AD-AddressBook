package ru.jsilver.itHelper.data.mappers;

import org.springframework.ldap.core.AttributesMapper;
import ru.jsilver.itHelper.data.OrgUnit;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

public class OrgUnitAttributesMapper implements AttributesMapper<OrgUnit> {

    @Override
    public OrgUnit mapFromAttributes(Attributes attributes) throws NamingException {
        OrgUnit orgUnit = new OrgUnit();

        Attribute name = attributes.get("name");
        if(name != null) {
            orgUnit.setName((String) name.get());
        }

        Attribute dn = attributes.get("distinguishedName");
        if (dn != null) {
            orgUnit.setDn((String) dn.get());
        }
        return orgUnit;
    }
}
