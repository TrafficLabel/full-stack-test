package com.trafficlabel.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.trafficlabel.dto.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonService {

    public Optional<Person> getPerson(int id) {
        return PersonProvider.getAllPersons().stream()
            .filter(person -> person.age == id)
            .findFirst();
    }

    public double getAverageAge() {
        return PersonProvider.getAllPersons().stream()
            .mapToDouble(person -> person.age)
            .average()
            .orElse(Double.NaN);
    }

    public Map<String, List<Person>> getPersonWithSameLastName() {
        return null;
    }
}
