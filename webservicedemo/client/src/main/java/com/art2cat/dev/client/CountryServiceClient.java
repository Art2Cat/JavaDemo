package com.art2cat.dev.client;


import com.art2cat.dev.*;
import java.util.logging.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryServiceClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = Logger
        .getLogger(CountryServiceClient.class.getSimpleName());

    public GetCountryResponse getCountryDetails(String country) {
        String uri = "http://localhost:8081/ws/";
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
            .marshalSendAndReceive(uri, request);
        LOGGER.info("Country : " + response.getCountry().getName());
        LOGGER.info("Capital : " + response.getCountry().getCapital());
        LOGGER.info("Population : " + response.getCountry().getPopulation());
        LOGGER.info("Currency : " + response.getCountry().getCurrency());
        return response;
    }
}
