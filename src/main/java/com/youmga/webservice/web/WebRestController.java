package com.youmga.webservice.web;

import com.youmga.webservice.domain.Posts;
import com.youmga.webservice.domain.PostsRepository;
import com.youmga.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }

    @GetMapping("/posts")
    public List<Posts> getPosts() {
        System.out.println("duark");
        System.out.println(postsRepository.findAll());
        return postsRepository.findAll();
    }

}