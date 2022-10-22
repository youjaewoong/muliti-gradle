package cdp.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@EnableFeignClients(basePackages = {"cdp"})
@Configuration
public class FeignConfig {

}
