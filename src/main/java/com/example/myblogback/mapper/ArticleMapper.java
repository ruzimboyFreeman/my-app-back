package com.example.myblogback.mapper;

import com.example.myblogback.dto.ArticleDto;
import com.example.myblogback.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    ArticleDto toDto(Article article);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    Article toEntity(ArticleDto dto);
}
