package net.mureng.api.todayexpression.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import net.mureng.api.core.annotation.CurrentUser;
import net.mureng.api.core.dto.ApiPageResult;
import net.mureng.api.todayexpression.component.TodayExpressionMapper;
import net.mureng.api.todayexpression.dto.TodayExpressionDto;
import net.mureng.core.member.entity.Member;
import net.mureng.core.todayexpression.service.TodayExpressionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "오늘의 표현 엔드포인트")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/today-expression")
public class TodayExpressionController {
    private final TodayExpressionService todayExpressionService;
    private final TodayExpressionMapper todayExpressionMapper;

    @ApiOperation(value = "오늘의 표현 가져오기", notes = "오늘의 표현을 가져옵니다.")
    @GetMapping
    public ResponseEntity<ApiPageResult<TodayExpressionDto>> getTodayExpressions(@CurrentUser Member member){
        return ResponseEntity.ok(ApiPageResult.ok(
                todayExpressionService.getTodayExpressions()
                .map(x -> todayExpressionMapper.toDto(x, member))
        ));
    }
}
