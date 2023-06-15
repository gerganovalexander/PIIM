package com.tinqin.academy.business.services;

import com.tinqin.academy.data.models.feignapi.SteamGameDescription;
import com.tinqin.academy.data.models.feignapi.SteamGames;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(name = "${feign.steam.name}", url = "${feign.steam.url}")
public interface SteamApiClient {
    @GetMapping("/api/storesearch/?l=en&cc=us&term={name}")
    SteamGames getSteamGamesByName(@PathVariable String name);

    @GetMapping("/appreviews/{id}?json=1")
    SteamGameDescription getSteamDescriptionById(@PathVariable Long id);
}
