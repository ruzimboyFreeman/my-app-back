package com.example.myblogback.service;

import com.example.myblogback.dto.ArticleDto;
import com.example.myblogback.entity.Article;
import com.example.myblogback.mapper.ArticleMapper;
import com.example.myblogback.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public Flux<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Mono<Article> getArticleById(UUID id) {
        return articleRepository.findById(id);
    }

    public Mono<Article> createArticle(ArticleDto articleDto) {
        Article article = articleMapper.toEntity(articleDto); // Convert DTO to Entity
        return articleRepository.save(article);
    }

    public Mono<Article> updateArticle(UUID id, Article updatedArticle) {
        return articleRepository.findById(id)
                .flatMap(existingArticle -> {
                    existingArticle.setTitle(updatedArticle.getTitle());
                    existingArticle.setContent(updatedArticle.getContent());
                    return articleRepository.save(existingArticle);
                });
    }

    public Mono<Article> deleteArticle(UUID id) {

        return articleRepository.findById(id).flatMap(article -> {
            article.setDeleted(true);
            return articleRepository.save(article);
        });
    }
}
