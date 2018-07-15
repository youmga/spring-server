package com.youmga.webservice.domain;

import com.youmga.webservice.domain.Test.Test;
import com.youmga.webservice.domain.Test.TestRepository;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTest {

    @Autowired
    TestRepository testRepository;

    @After
    public void cleanup() {
        testRepository.deleteAll();
    }

    @org.junit.Test
    public void 게시글저장_불러오기() {
        // given - 테스트 기반 환경을 구축
        testRepository.save(Test.builder()
                .title("test title")
                .content("test content")
                .author("test author")
                .build());

        // when - 테스트 동작
        List<Test> testList = testRepository.findAll();

        // then - 테스트 결과 검증
        Test test = testList.get(0);
        assertThat(test.getTitle(), is("test title"));
        assertThat(test.getContent(), is("test content"));
    }

    @org.junit.Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        testRepository.save(Test.builder()
                .title("test title")
                .content("test content")
                .author("test author")
                .build());

        //when
        List<Test> testList = testRepository.findAll();

        //then
        Test test = testList.get(0);
        assertTrue(test.getCreatedDate().isAfter(now));
        assertTrue(test.getModifiedDate().isAfter(now));
    }
}
