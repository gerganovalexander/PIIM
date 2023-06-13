package com.tinqin.academy.business.services.contracts;


import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "${feign.score.name}", url = "${feign.score.url}")
public interface GameScoreExtractorService {
}
