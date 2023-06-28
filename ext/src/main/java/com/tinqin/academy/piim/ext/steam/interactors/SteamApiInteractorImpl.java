package com.tinqin.academy.piim.ext.steam.interactors;

import com.tinqin.academy.piim.ext.steam.feign.SteamApiClient;
import com.tinqin.academy.piim.ext.steam.models.SteamGameDescription;
import com.tinqin.academy.piim.ext.steam.models.SteamGames;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteamApiInteractorImpl implements SteamApiInteractor {

    private final SteamApiClient steamApiClient;

    @Override
    public String getReviewByName(String name) {

        SteamGames steamGames = steamApiClient.getSteamGamesByName(name);
        if (steamGames.getTotal().equals(0L)) {
            return "N/A";
        }

        SteamGameDescription steamGameDescription = steamApiClient.getSteamDescriptionById(
                steamGames.getGames().get(0).getId());
        return steamGameDescription.getSteamGameReview().getReviewScore();
    }
}
