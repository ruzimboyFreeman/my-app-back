package com.example.myblogback.dto;

import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
}
