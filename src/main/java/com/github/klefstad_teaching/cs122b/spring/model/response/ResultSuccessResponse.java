package com.github.klefstad_teaching.cs122b.spring.model.response;

import com.github.klefstad_teaching.cs122b.core.base.ResponseModel;

public class ResultSuccessResponse extends ResponseModel<ResultSuccessResponse>
{
    private Integer sum;

    public Integer getSum()
    {
        return sum;
    }

    public ResultSuccessResponse setSum(Integer sum)
    {
        this.sum = sum;
        return this;
    }
}
