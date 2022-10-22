package cdp.common.config;

import java.time.YearMonth;

import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@OpenAPIDefinition(info = @Info(
		title = "CDP 서비스",
		description = "CDP 대해 설명하는 문서입니다.",
		version = "1.0"),
		servers = @Server(url = "/", description = "Default server url"))
@Configuration
public class OpenApiConfig {

	static {
		/**
		 * ParameterObject Class 내부에 YearMonth Type 을 선언할 경우, /v3/api-docs 호출시에 StackOverFlow 가 발생합니다.
		 * 이를 방지하기 위해 YearMonth Type 을 SimpleType 으로 표시하도록 조정합니다.
		 */
		SpringDocUtils.getConfig().addSimpleTypesForParameterObject(YearMonth.class);
	}

	@Bean
	public OpenApiCustomiser openApiCustomiser() {
		return openApi -> openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
			ApiResponses apiResponses = operation.getResponses();
			apiResponses.addApiResponse("404", new ApiResponse().description("Not Found"));
			apiResponses.addApiResponse("500", new ApiResponse().description("Server Error"));
		}));
	}
}
