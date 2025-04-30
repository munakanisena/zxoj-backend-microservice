package com.katomegumi.zxojbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.katomegumi.common.ErrorCode;
import com.katomegumi.exception.BusinessException;
import com.katomegumi.model.codesandbox.ExecuteCodeRequest;
import com.katomegumi.model.codesandbox.ExecuteCodeResponse;
import com.katomegumi.zxojbackendjudgeservice.judge.codesandbox.CodeSandbox;


/**
 * @author : 惠
 * @description :
 * @createDate : 2025/4/18 下午5:32
 */
public class RemoteCodeSandbox implements CodeSandbox {

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        String url= "http://192.168.88.133:8124/executeCode";
        String str= JSONUtil.toJsonStr(executeCodeRequest);
        String response = HttpUtil.createPost(url)
                .body(str)
                .header(AUTH_REQUEST_HEADER,AUTH_REQUEST_SECRET)
                .execute()
                .body();
        if (StrUtil.isBlank(response)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"代码沙箱错错误"+response);
        }
        ExecuteCodeResponse executeCodeResponse = JSONUtil.toBean(response, ExecuteCodeResponse.class);
        System.out.println(executeCodeResponse);
        return executeCodeResponse;
    }
}

