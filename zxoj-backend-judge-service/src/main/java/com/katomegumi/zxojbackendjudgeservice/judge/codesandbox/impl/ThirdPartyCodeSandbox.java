package com.katomegumi.zxojbackendjudgeservice.judge.codesandbox.impl;


import com.katomegumi.model.codesandbox.ExecuteCodeRequest;
import com.katomegumi.model.codesandbox.ExecuteCodeResponse;
import com.katomegumi.zxojbackendjudgeservice.judge.codesandbox.CodeSandbox;

/**
 * @author : 惠
 * @description :
 * @createDate : 2025/4/18 下午5:32
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方沙箱");
        return null;
    }
}

