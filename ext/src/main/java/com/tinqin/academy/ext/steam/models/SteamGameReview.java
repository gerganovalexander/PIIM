package com.tinqin.academy.ext.steam.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SteamGameReview {
    @JsonProperty("review_score_desc")
    String reviewScore;
}
