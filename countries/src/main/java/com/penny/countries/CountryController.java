package com.penny.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
