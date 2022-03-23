package com.github.klefstad_teaching.cs122b.activity.one.rest;

import com.github.klefstad_teaching.cs122b.activity.one.model.response.ResultSuccessResponse;
import com.github.klefstad_teaching.cs122b.core.error.ResultError;
import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController
{
    @GetMapping("/result/sum")
    public ResponseEntity<ResultSuccessResponse> detail(
        @RequestParam("numX") Integer numX,
        @RequestParam("numY") Integer numY)
    {
        if (numX < 0 || numY < 0) {
            throw new ResultError(BasicResults.DATA_CONTAINS_INVALID_INTEGERS);
        }

        ResultSuccessResponse response  = new ResultSuccessResponse()
            .setResult(BasicResults.CALCULATION_SUCCESSFUL)
            .setSum(numX + numY);

        return response.toResponse();
    }
}
