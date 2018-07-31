package com.youmga.webservice.web.controller;

import com.youmga.webservice.domain.test.Test;
import com.youmga.webservice.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // @Controller & @ResponseBody
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {

    private TestService testService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/get") // ?sort=id,asc
    public List<Test> getAllTest(Sort sort) {
        return testService.findAllOrderBySort(sort);
    }

    @GetMapping("/get/{id}")
    public Test getTestById(@PathVariable long id) {
        return testService.findById(id);
    }

    @PostMapping("/post")
    public Test createTest(@Valid @RequestBody Test test) {
        return testService.create(test);
    }

    @PutMapping("/put/{id}")
    public Test updateTest(@PathVariable long id, @Valid @RequestBody Test test) {
        return testService.update(id, test);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable long id) {
        return testService.deleteById(id);
    }
}