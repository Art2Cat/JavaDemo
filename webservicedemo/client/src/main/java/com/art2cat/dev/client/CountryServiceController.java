package com.art2cat.dev.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryServiceController {

    @Autowired
    CountryServiceClient countryServiceClient;

    @GetMapping("/getCountryCurrency")
    public String getCountryDetails(@RequestParam(name = "country") String country) {

        return countryServiceClient.getCountryDetails(country).getCountry().getCurrency()
            .toString();
    }


}
