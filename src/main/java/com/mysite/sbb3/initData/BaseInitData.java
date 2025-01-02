package com.mysite.sbb3.initData;

import com.mysite.sbb3.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    @Lazy
    @Autowired
    private BaseInitData self;

    private final QuestionService questionService;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work();
        };
    }

    public void work() {
        for (int i = 0; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용 없음";
            this.questionService.create(subject, content);
        }
    }
}
