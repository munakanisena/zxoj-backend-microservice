package com.katomegumi.zxojbackendserviceclient.service;

import com.katomegumi.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : 惠
 * @description : 判题服务
 * @createDate : 2025/4/18 下午7:33
 */
@FeignClient(name = "zxoj-backend-judge-service",path = "/api/judge/inner")
public interface JudgeFeignClient {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId);
}

