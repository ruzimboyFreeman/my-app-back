package com.example.myblogback.controller;

import com.example.myblogback.dto.ArticleDto;
import com.example.myblogback.entity.Article;
import com.example.myblogback.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public Flux<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Article>> getArticleById(@PathVariable UUID id) {
        return articleService.getArticleById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Article>> createArticle(@RequestBody ArticleDto articleDto) {
        return articleService.createArticle(articleDto)
                .map(savedArticle -> ResponseEntity.ok(savedArticle));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Article>> updateArticle(@PathVariable UUID id, @RequestBody Article article) {
        return articleService.updateArticle(id, article)
                .map(updatedArticle -> ResponseEntity.ok(updatedArticle))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

//    @DeleteMapping("/{id}")
//    public Mono<ResponseEntity<Void>> deleteArticle(@PathVariable Long id) {
//        return articleService.deleteArticle(id)
//                .map(article -> ResponseEntity.noContent().build())
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
}
