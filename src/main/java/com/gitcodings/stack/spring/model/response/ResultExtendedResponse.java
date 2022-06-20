package com.gitcodings.stack.spring.model.response;

import com.gitcodings.stack.core.base.ResponseModel;

public class ResultExtendedResponse extends ResponseModel<ResultExtendedResponse>
{
    private Integer sum;

    public Integer getSum()
    {
        return sum;
    }

    public ResultExtendedResponse setSum(Integer sum)
    {
        this.sum = sum;
        return this;
    }
}
