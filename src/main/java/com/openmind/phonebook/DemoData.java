package com.openmind.phonebook;

import com.github.javafaker.Faker;
import com.openmind.phonebook.domain.Location;
import com.openmind.phonebook.domain.Person;
import com.openmind.phonebook.repository.LocationRepository;
import com.openmind.phonebook.repository.PersonRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DemoData implements ApplicationRunner {

    private final PersonRepository personRepository;
    private final LocationRepository locationRepository;

    public DemoData(PersonRepository personRepository, LocationRepository locationRepository) {
        this.personRepository = personRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        locationRepository.save(new Location(
                "PA",
                "Pittsburgh",
                "123 Testing", "Suite A",
                "Pittsburgh", "PA", "15233", "USA",
                "123-123-1234",
                "123-123-1234"
        ));
        locationRepository.save(new Location(
                "NY",
                "New York",
                "State st and Washington Ave", "",
                "Albany", "NY", "12224", "USA",
                "123-123-1234",
                "123-123-1234"
        ));
        locationRepository.save(new Location(
                "CO",
                "Colorado",
                "200 E Colfax Ave", "",
                "Denver", "CO", "80203", "USA",
                "123-123-1234",
                "123-123-1234"
        ));

        Faker faker = new Faker();
        String[] s = {"PA", "NY", "CO"};
        int i;

        for (i = 2; i < 1000; i++) {
            Random ran = new Random();
            String randomLocation = s[ran.nextInt(s.length)];

            personRepository.save(new Person(
                    String.format("%05d", i), randomLocation,
                    faker.name().firstName(), faker.name().lastName(),
                    faker.name().title(), faker.commerce().department(),
                    faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(),
                    faker.phoneNumber().cellPhone(),
                    "0001"
                    ));
        }
    }
}
