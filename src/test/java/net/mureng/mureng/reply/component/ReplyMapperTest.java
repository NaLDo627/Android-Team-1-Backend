package net.mureng.mureng.reply.component;

import net.mureng.mureng.common.EntityCreator;
import net.mureng.mureng.reply.dto.ReplyDto;
import net.mureng.mureng.reply.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    ReplyMapper replyMapper;

    private final Reply reply = EntityCreator.createReplyEntity();
    private final ReplyDto.ReadOnly replyDto = EntityCreator.createReplyDto();

    @Test
    public void 엔티티에서_DTO변환_테스트() {
        ReplyDto.ReadOnly mappedDto = replyMapper.toDto(reply);
        assertEquals(replyDto.getReplyId(), mappedDto.getReplyId());
        assertEquals(replyDto.getContent(), mappedDto.getContent());
        assertEquals(replyDto.getContent(), mappedDto.getContent());
        assertEquals(replyDto.getAuthor().getMemberId(), mappedDto.getAuthor().getMemberId());
        assertEquals(replyDto.getQuestion().getQuestionId(), mappedDto.getQuestion().getQuestionId());
        assertEquals(replyDto.getReplyLikeCount(), mappedDto.getReplyLikeCount());
    }

    @Test
    public void DTO에서_엔티티변환_테스트() {
        Reply mappedEntity = replyMapper.toEntity(replyDto);
        assertEquals(reply.getContent(), mappedEntity.getContent());
        assertEquals(reply.getImage(), mappedEntity.getImage());
    }

}