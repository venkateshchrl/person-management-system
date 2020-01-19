package com.demo.pms.repositories;

import com.demo.pms.repositories.predicates.PersonPredicates;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import java.util.Map;

public class PersonPredicateBuilder {
    private Map<String, String> filters;

    public PersonPredicateBuilder withFilter(Map<String, String> filter){
        this.filters = filter;
        return this;
    }

    public Predicate build(){
        if(filters.size() == 0){
            return null;
        }
        BooleanBuilder result = new BooleanBuilder();
        for(String filter: filters.keySet()){
            switch (filter){
                case "firstName":
                    result = result.and(PersonPredicates.withFirstName(filters.get(filter)));
                    break;
                case "lastName":
                    result = result.and(PersonPredicates.withLastName(filters.get(filter)));
                    break;
                case "name":
                    result = result.and(PersonPredicates.withName(filters.get(filter)));
                    break;
            }
        }
        return result.getValue();
    }
}
