package net.mureng.mureng.question.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.mureng.mureng.member.entity.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @Column(length = 20)
    private String category;

    @Column(nullable = false, length = 150)
    private String content;

    @Column(name = "ko_content", nullable = false)
    private String koContent;

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate = LocalDateTime.now();

    @Builder
    public Question(Long questionId, Member memberId, String category, String content, String koContent, LocalDateTime regDate) {
        this.questionId = questionId;
        this.memberId = memberId;
        this.category = category;
        this.content = content;
        this.koContent = koContent;
        this.regDate = regDate;
    }
}
