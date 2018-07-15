package com.youmga.webservice.domain.Test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> { // DB Layer 접근자
}
