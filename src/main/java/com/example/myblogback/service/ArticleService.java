package com.example.myblogback.service;

import com.example.myblogback.entity.Article;
import com.example.myblogback.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Flux<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Mono<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Mono<Article> createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Mono<Article> updateArticle(Long id, Article updatedArticle) {
        return articleRepository.findById(id)
                .flatMap(existingArticle -> {
                    existingArticle.setTitle(updatedArticle.getTitle());
                    existingArticle.setContent(updatedArticle.getContent());
                    return articleRepository.save(existingArticle);
                });
    }

    public Mono<Article> deleteArticle(Long id) {

        return articleRepository.findById(id).flatMap(article -> {
            article.setDeleted(true);
            return articleRepository.save(article);
        });
    }
}
