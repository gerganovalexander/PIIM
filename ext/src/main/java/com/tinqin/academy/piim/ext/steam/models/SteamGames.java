package com.tinqin.academy.piim.ext.steam.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SteamGames {
    Long total;

    @JsonProperty("items")
    List<SteamGame> games;
}
