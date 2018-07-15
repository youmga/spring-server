package com.youmga.webservice.service;

import com.youmga.webservice.domain.Test.Test;
import com.youmga.webservice.core.exception.ResourceNotFoundException;
import com.youmga.webservice.domain.Test.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class TestService {

    private TestRepository testRepository;

    @Transactional
    public Test create(Test test) {
        return testRepository.save(test);
    }

    @Transactional(readOnly = true)
    public List<Test> findAllOrderBySort(Sort sort) {
        return testRepository.findAll(sort);
    }

    @Transactional(readOnly = true)
    public Test findById(Long id) {
        return testRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.builder().resourceName("Test").fieldName("id").fieldValue(id).build());
    }

    @Transactional
    public Test update(long id, Test testRequest) {
        return testRepository.findById(id)
                .map(posts -> {
                    posts.setTitle(testRequest.getTitle());
                    posts.setContent(testRequest.getContent());
                    posts.setAuthor(testRequest.getAuthor());
                    return testRepository.save(posts);
                }).orElseThrow(() -> ResourceNotFoundException.builder().resourceName("Test").fieldName("id").fieldValue(id).build());
    }

    @Transactional
    public ResponseEntity<?> deleteById(long id) {
        return testRepository.findById(id)
                .map(posts -> {
                    testRepository.delete(posts);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> ResourceNotFoundException.builder().resourceName("Test").fieldName("id").fieldValue(id).build());
    }
}
