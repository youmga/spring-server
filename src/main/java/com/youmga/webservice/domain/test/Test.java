package com.youmga.webservice.domain.test;

import com.youmga.webservice.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 (프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스 생성 허용)
@Data // @Getter & @Setter & @NonNull & @EqualsAndHashCode & @ToString
@Entity // 언더스코어 네이밍(_) 테이블과 매칭
public class Test extends BaseTimeEntity { // 실제 DB 테이블과 매칭될 Entity 클래스

    @Id // 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Test(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
