package com.penny.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
//Beans - POJOs managed by Spring
@RequestMapping("/data")
public class CountryController
{
    //localhost:8080/data/names/all  - return the names of all the countries alphabetically
    @GetMapping(value="/names/all", produces={"application/json"})
    public ResponseEntity<?> getAllCountries()        //okay if not know the type
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    //localhost:8080/data/names/start/{letter} - return the countries alphabetically that begin with the given letter
    @GetMapping(value="/names/start/{letter}", produces={"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter)
    {
        ArrayList<Country> filtered = new ArrayList<>(CountriesApplication.ourCountryList.findCountries((c) -> c.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter)));
        filtered.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    //localhost:8080/data/names/size/{number} - return the countries alphabetically that have a name equal to or longer than the given length
    @GetMapping(value="/names/size/{number}", produces={"application/json"})
    public ResponseEntity<?> getCountriesByNameSize(@PathVariable int number)
    {
        ArrayList<Country> filtered = new ArrayList<>(CountriesApplication.ourCountryList.findCountries((c) -> c.getName().length() >= number));
        filtered.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    //localhost:8080/data/population/size/{people} - return the countries that have a population equal to or greater than the given population
    @GetMapping(value="/population/size/{people}", produces={"application/json"})
    public ResponseEntity<?> getCountriesByPopulation(@PathVariable long people)
    {
        ArrayList<Country> filtered = new ArrayList<>(CountriesApplication.ourCountryList.findCountries((c) -> c.getPopulation() >= people));
        filtered.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    //localhost:8080/data/age/age/{age} - return the countries that have a median age equal to or greater than the given age
    @GetMapping(value="/age/age/{age}", produces={"application/json"})
    public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age)
    {
        ArrayList<Country> filtered = new ArrayList<>(CountriesApplication.ourCountryList.findCountries((c) -> c.getMedianAge() >= age));
        filtered.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    //localhost:8080/data/population/min - return the country with the smallest population
    @GetMapping(value="/population/min", produces={"application/json"})
    public ResponseEntity<?> getCountryWithMinPopulation()
    {
        Country minPopulation = Collections.min(CountriesApplication.ourCountryList.countryList, Comparator.comparingLong(Country::getPopulation));
        return new ResponseEntity<>(minPopulation, HttpStatus.OK);
    }

    //localhost:8080/data/population/max - return the country with the largest population
    @GetMapping(value="/population/max", produces={"application/json"})
    public ResponseEntity<?> getCountryWithMaxPopulation()
    {
        Country maxPopulation = Collections.max(CountriesApplication.ourCountryList.countryList, Comparator.comparingLong(Country::getPopulation));
        return new ResponseEntity<>(maxPopulation, HttpStatus.OK);
    }

    //localhost:8080/data/age/min - return the country with the smallest median age
    @GetMapping(value="/age/min", produces={"application/json"})
    public ResponseEntity<?> getCountryWithMinMedianAge()
    {
        Country minMedianAge = Collections.min(CountriesApplication.ourCountryList.countryList, Comparator.comparingLong(Country::getMedianAge));
        return new ResponseEntity<>(minMedianAge, HttpStatus.OK);
    }

    //localhost:8080/data/age/max - return the country the the greatest median age
    @GetMapping(value="/age/max", produces={"application/json"})
    public ResponseEntity<?> getCountryWithMaxMedianAge()
    {
        Country maxMedianAge = Collections.max(CountriesApplication.ourCountryList.countryList, Comparator.comparingLong(Country::getMedianAge));
        return new ResponseEntity<>(maxMedianAge, HttpStatus.OK);
    }

    //for stretch
    //localhost:8080/data/population/median - return the country with the median population

    //localhost:8080/data/age/median - return the country with the median median age
}
