package com.demo.pms.repositories.predicates;

import com.demo.pms.entities.QPersonEntity;
import com.querydsl.core.types.dsl.BooleanExpression;

public class PersonPredicates {
    public static BooleanExpression withFirstName(String firstName){
        if(firstName == null)
            return null;
        return QPersonEntity.personEntity.firstName.equalsIgnoreCase(firstName);
    }

    public static BooleanExpression withLastName(String lastName){
        if(lastName == null)
            return null;
        return QPersonEntity.personEntity.lastName.equalsIgnoreCase(lastName);
    }

    public static BooleanExpression withName(String name){
        if(name == null || name.isEmpty())
            return null;
        return QPersonEntity.personEntity.firstName.containsIgnoreCase(name).or(QPersonEntity.personEntity.lastName.containsIgnoreCase(name));
    }
}
