package com.tinqin.academy.ext.steam.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SteamGames {
    @JsonProperty("items")
    List<SteamGame> games;
}
