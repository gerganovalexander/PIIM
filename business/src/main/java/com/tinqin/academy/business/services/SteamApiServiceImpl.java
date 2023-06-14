package com.tinqin.academy.business.services;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteamApiServiceImpl implements com.tinqin.academy.business.services.contracts.SteamApiService {

    private final SteamApiClient steamApiClient;

    @Override
    public String getReviewByName(String name) {

        JsonNode steamGame = steamApiClient.getSteamGameIdByName(name);
        Long gameId = steamGame.get("items").get(0).get("id").asLong();

        JsonNode steamGameScore = steamApiClient.getSteamScoreById(gameId);
        return steamGameScore.get("query_summary").get("review_score_desc").asText();
    }
}
