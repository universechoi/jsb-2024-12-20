package com.mysite.sbb3.answer;

import com.mysite.sbb3.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = Answer
                .builder()
                .content(content)
                .question(question)
                .build();
        this.answerRepository.save(answer);
    }
}
