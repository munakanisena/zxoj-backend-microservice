package com.katomegumi.zxojbackendjudgeservice.judge.strategy;


import com.katomegumi.model.codesandbox.JudgeInfo;

public interface JudgeStrategy {
    /**
     * 执行判题(结果)
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
