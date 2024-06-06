package com.trafficlabel.resource;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.trafficlabel.dto.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonRestControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void averageAgeTest() {
        var averageAge = restTemplate.getForObject("http://localhost:" + port + "/api/v1/get-average-age", Double.class);
        Assert.assertEquals((Double) 33.875d, averageAge);
    }

    @Test
    public void getPersonByIdTest() {
        var person = restTemplate.getForObject("http://localhost:" + port + "/api/v1/get-person/1", Person.class);
        Assert.assertEquals((Integer) 1, person.id);
    }

    @Test
    public void getSameLastNamePersonsTest() {
        var map = restTemplate.getForObject("http://localhost:" + port + "/api/v1/get-persons-same-last-name", Map.class);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals("Smith", map.keySet().iterator().next());
        var persons = (List<Person>) map.get("Smith");
        Assert.assertEquals(2, persons.size());
    }
}
