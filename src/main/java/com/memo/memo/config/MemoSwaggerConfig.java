package com.memo.memo.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.ExternalDocumentation;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
public class MemoSwaggerConfig {
    //Swagger Ui에 표시될 기본 정보
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Swagger Title")
                        .description("설명!!")
                        .version("v2") //
                        .contact(new Contact()
                                .name("사용자명")
                                .url("url")
                                .email("ih.park@fusionsoft.co.kr")
                        )
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8081").description("로컬 서버")
                ))
                .externalDocs(new ExternalDocumentation()
                        .description("더 많은 문서 보기")
                        .url("https://swagger.io/docs/")
                );
    }
    // API 그룹핑 (선택사항, 많을 때 구분용)
    @Bean
    public GroupedOpenApi memoApi() {
        return GroupedOpenApi.builder()
                .group("메모 API") // Swagger UI 상단의 그룹 이름
                .pathsToMatch("/api/memo/**") // 매핑 경로
                .build();
    }

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("회원 API") // Swagger UI 상단의 그룹 이름
                .pathsToMatch("/v2/users/**") // 매핑 경로
                .build();
    }
}
