package com.example.myblogback.mapper;

import com.example.myblogback.dto.ArticleDto;
import com.example.myblogback.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    ArticleDto toDto(Article article);

    Article toEntity(ArticleDto dto);
}
