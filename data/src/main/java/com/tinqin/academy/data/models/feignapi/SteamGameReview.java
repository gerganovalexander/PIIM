package com.tinqin.academy.data.models.feignapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SteamGameReview {
    @JsonProperty("review_score_desc")
    String reviewScore;
}
