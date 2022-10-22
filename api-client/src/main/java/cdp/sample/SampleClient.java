package cdp.sample;

import org.springframework.cloud.openfeign.FeignClient;

import cdp.sample.api.SampleApi;

@FeignClient(name = "cdp-board-client", url = "${feign.cdp.url}")
public interface SampleClient extends SampleApi {}
