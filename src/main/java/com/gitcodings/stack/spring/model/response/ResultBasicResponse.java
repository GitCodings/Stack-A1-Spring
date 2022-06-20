package com.gitcodings.stack.spring.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gitcodings.stack.core.result.Result;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBasicResponse
{
    private Result result;
    private Integer sum;

    public Result getResult()
    {
        return result;
    }

    public ResultBasicResponse setResult(Result result)
    {
        this.result = result;
        return this;
    }

    public Integer getSum()
    {
        return sum;
    }

    public ResultBasicResponse setSum(Integer sum)
    {
        this.sum = sum;
        return this;
    }
}
