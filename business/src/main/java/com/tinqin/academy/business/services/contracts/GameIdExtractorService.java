package com.tinqin.academy.business.services.contracts;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "${feign.id.name}", url = "${feign.id.url}")
public interface GameIdExtractorService {


}
