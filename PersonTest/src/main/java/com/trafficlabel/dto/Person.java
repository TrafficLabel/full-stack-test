package com.trafficlabel.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Builder;

@Builder
public class Person {

    public final Integer id;
    public final String firstName;
    public final String lastName;
    public final Integer age;
    public final Address address;
    public final String phoneNumber;

    @JsonCreator
    public Person(Integer id,
                  String firstName,
                  String lastName,
                  Integer age,
                  Address address,
                  String phoneNumber) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Builder
    public static class Address {
        public final String address1;
        public final String address2;
        public final String city;
        public final String postcode;

        @JsonCreator
        public Address(String address1,
                       String address2,
                       String city,
                       String postcode) {

            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.postcode = postcode;
        }
    }
}
