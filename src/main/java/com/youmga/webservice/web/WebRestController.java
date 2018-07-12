package com.youmga.webservice.web;

import com.youmga.webservice.dto.PostsSaveRequestDto;
import com.youmga.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }

//    @GetMapping("/posts")
//    public List<Posts> getPosts() {
//        System.out.println("duark");
//        System.out.println(postsRepository.findAll());
//        return postsRepository.findAll();
//    }

}