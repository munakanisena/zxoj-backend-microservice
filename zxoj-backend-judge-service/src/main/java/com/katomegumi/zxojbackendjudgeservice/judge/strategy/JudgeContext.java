package com.katomegumi.zxojbackendjudgeservice.judge.strategy;


import com.katomegumi.model.codesandbox.JudgeInfo;
import com.katomegumi.model.dto.question.JudgeCase;
import com.katomegumi.model.entity.Question;
import com.katomegumi.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @author : 惠
 * @description : 上下文类
 * @createDate : 2025/4/19 上午11:43
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> outputList;

    private List<String> inputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}

