package com.epam.rudenkov.soap_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetPlayerRequest;
import io.spring.guides.gs_producing_web_service.GetPlayerResponse;

@Endpoint
public class PlayerEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerEndpoint(PlayerRepository countryRepository) {
        this.playerRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlayerRequest")
    @ResponsePayload
    public GetPlayerResponse getPlayer(@RequestPayload GetPlayerRequest request) {
        GetPlayerResponse response = new GetPlayerResponse();
        response.setPlayer(playerRepository.findCountry(request.getSuname()));

        return response;
    }
}
