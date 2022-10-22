package cdp.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;


@Configuration
public class JacksonConfig {
	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
		return new Jackson2ObjectMapperBuilder()
				.featuresToEnable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)
				.featuresToEnable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
	}
}
