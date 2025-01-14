package com.mysite.sbb3;

import com.mysite.sbb3.question.Question;
import com.mysite.sbb3.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
public class QuestionTest {

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

    @Test
    void findAllTest() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.getFirst();
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void findByIdTest() {
        Optional<Question> oq = this.questionRepository.findById(1L);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }

    @Test
    void findBySubjectTest() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, q.getId());
    }

    @Test
    void findBySubjectAndContentTest() {
        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
    }

    @Test
    void findBySubjectLikeTest() {
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.getFirst();
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Transactional
    @Test
    void modifyTest() {
        Optional<Question> oq = this.questionRepository.findById(1L);
        assertTrue(oq.isPresent());

        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

    @Transactional
    @Test
    void deleteTest() {
        assertEquals(2, this.questionRepository.count());

        Optional<Question> oq = this.questionRepository.findById(1L);
        assertTrue(oq.isPresent());

        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }
}
