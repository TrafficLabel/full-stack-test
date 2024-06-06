package com.trafficlabel.resource;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trafficlabel.dto.Person;
import com.trafficlabel.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService personService;

    @ResponseBody
    @GetMapping("/api/v1/get-person/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.getPerson(id).orElse(null);
    }

    @ResponseBody
    @GetMapping("/api/v1/get-average-age")
    public double getAverageAge() {
        return personService.getAverageAge();
    }

    @ResponseBody
    @GetMapping("/api/v1/get-persons-same-last-name")
    public Map<String, List<Person>> getPersonsWithTheSameLastName() {
        return personService.getPersonWithSameLastName();
    }
}
