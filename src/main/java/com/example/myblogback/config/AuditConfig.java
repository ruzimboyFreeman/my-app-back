package com.example.myblogback.config;

import com.example.myblogback.entity.BaseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Configuration
@EnableR2dbcAuditing
public class AuditConfig {
    @Bean
    public BeforeConvertCallback<BaseEntity> auditingCallback() {
        return (entity, tableName) -> {
            if (entity.getCreatedAt() == null) {
                entity.setCreatedAt(LocalDateTime.now());
            }
            entity.setUpdatedAt(LocalDateTime.now());
            return Mono.just(entity);
        };
    }
}
