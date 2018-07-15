package com.youmga.webservice.dto;

import com.youmga.webservice.domain.Posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PostsMainResponseDto {

    private long id;
    private String title;
    private String content;
    private String author;
    private String createdDate;
    private String modifedDate;

    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
        createdDate = toDateStringTime(entity.getCreatedDate());
        modifedDate = toDateStringTime(entity.getModifiedDate());
    }

    private String toDateStringTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
