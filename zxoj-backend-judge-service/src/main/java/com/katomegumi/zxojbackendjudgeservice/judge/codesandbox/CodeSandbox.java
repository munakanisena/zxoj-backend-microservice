package com.katomegumi.zxojbackendjudgeservice.judge.codesandbox;


import com.katomegumi.model.codesandbox.ExecuteCodeRequest;
import com.katomegumi.model.codesandbox.ExecuteCodeResponse;

public interface CodeSandbox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
