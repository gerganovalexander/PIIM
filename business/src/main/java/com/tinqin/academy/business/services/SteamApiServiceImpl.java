package com.tinqin.academy.business.services;

import com.tinqin.academy.data.models.feignapi.SteamGameDescription;
import com.tinqin.academy.data.models.feignapi.SteamGames;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteamApiServiceImpl implements com.tinqin.academy.business.services.contracts.SteamApiService {

    private final SteamApiClient steamApiClient;

    @Override
    public String getReviewByName(String name) {

        SteamGames steamGames = steamApiClient.getSteamGamesByName(name);
        Long gameId = steamGames.getGames().get(0).getId();

        SteamGameDescription steamGameDescription = steamApiClient.getSteamDescriptionById(gameId);
        return steamGameDescription.getSteamGameReview().getReviewScore();
    }
}
