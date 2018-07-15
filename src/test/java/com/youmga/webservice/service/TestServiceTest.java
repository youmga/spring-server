package com.youmga.webservice.service;

import com.youmga.webservice.domain.Test.Test;
import com.youmga.webservice.domain.Test.TestRepository;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Autowired
    private TestRepository testRepository;

    @After
    public void cleanup() {
        testRepository.deleteAll();
    }

    @org.junit.Test
    public void Test데이터가_test테이블에_저장된다 () {
        //given
        Test testRequest = Test.builder()
                .title("test title")
                .content("test content")
                .author("test author")
                .build();

        //when
        testService.create(testRequest);

        //then
        Test test = testRepository.findAll().get(0);
        assertThat(test.getTitle()).isEqualTo(testRequest.getTitle());
        assertThat(test.getContent()).isEqualTo(testRequest.getContent());
        assertThat(test.getAuthor()).isEqualTo(testRequest.getAuthor());
    }
}
