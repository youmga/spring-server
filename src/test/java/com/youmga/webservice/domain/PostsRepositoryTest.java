package com.youmga.webservice.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given - 테스트 기반 환경을 구축
        postsRepository.save(Posts.builder()
                .title("test title")
                .content("test content")
                .author("test author")
                .build());

        // when - 테스트 동작
        List<Posts> postsList = postsRepository.findAll();

        // then - 테스트 결과 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("test title"));
        assertThat(posts.getContent(), is("test content"));
    }
}
