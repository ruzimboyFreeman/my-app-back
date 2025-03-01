package com.example.myblogback.repository;

import com.example.myblogback.entity.Article;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
@EnableR2dbcRepositories
public interface ArticleRepository extends ReactiveCrudRepository<Article,Long> {
    Flux<Article> findByTitleContainingIgnoreCase(String keyword);

   Mono<Article> findById(Long id);
}
