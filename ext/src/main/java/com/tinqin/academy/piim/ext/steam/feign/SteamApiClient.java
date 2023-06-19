package com.tinqin.academy.piim.ext.steam.feign;

import com.tinqin.academy.piim.ext.steam.models.SteamGameDescription;
import com.tinqin.academy.piim.ext.steam.models.SteamGames;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "${feign.steam.name}", url = "${feign.steam.url}")
public interface SteamApiClient {
    @GetMapping("/api/storesearch/?l=en&cc=us&term={name}")
    SteamGames getSteamGamesByName(@PathVariable String name);

    @GetMapping("/appreviews/{id}?json=1")
    SteamGameDescription getSteamDescriptionById(@PathVariable Long id);
}
