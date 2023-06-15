package com.tinqin.academy.ext.steam.interactors;

import com.tinqin.academy.ext.steam.models.SteamGameDescription;
import com.tinqin.academy.ext.steam.models.SteamGames;
import com.tinqin.academy.ext.steam.feign.SteamApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteamApiInteractorImpl implements SteamApiInteractor {

    private final SteamApiClient steamApiClient;

    @Override
    public String getReviewByName(String name) {

        SteamGames steamGames = steamApiClient.getSteamGamesByName(name);
        Long gameId = steamGames.getGames().get(0).getId();

        SteamGameDescription steamGameDescription = steamApiClient.getSteamDescriptionById(gameId);
        return steamGameDescription.getSteamGameReview().getReviewScore();
    }
}