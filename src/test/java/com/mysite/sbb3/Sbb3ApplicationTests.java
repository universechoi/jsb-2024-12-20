package com.mysite.sbb3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sbb3ApplicationTests {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    void saveTest() {
        Question q1 = Question
                .builder()
                .subject("sbb가 무엇인가요?")
                .content("sbb에 대해서 알고 싶습니다.")
                .build();
        this.questionRepository.save(q1);

        Question q2 = Question
                .builder()
                .subject("스프링 부트 모델 질문입니다.")
                .content("id는 자동으로 생성되나요?")
                .build();
        this.questionRepository.save(q2);
    }
}
