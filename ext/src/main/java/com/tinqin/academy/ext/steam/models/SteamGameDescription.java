package com.tinqin.academy.ext.steam.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SteamGameDescription {
    @JsonProperty("query_summary")
    SteamGameReview steamGameReview;
}
