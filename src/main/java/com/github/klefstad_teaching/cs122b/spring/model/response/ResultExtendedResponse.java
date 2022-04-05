package com.github.klefstad_teaching.cs122b.spring.model.response;

import com.github.klefstad_teaching.cs122b.core.base.ResponseModel;

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
