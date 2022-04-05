package com.github.klefstad_teaching.cs122b.spring.rest;

import com.github.klefstad_teaching.cs122b.core.error.ResultError;
import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import com.github.klefstad_teaching.cs122b.spring.model.response.ResultBasicResponse;
import com.github.klefstad_teaching.cs122b.spring.model.response.ResultExtendedResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController
{
    @GetMapping("/result/basic")
    public ResponseEntity<ResultBasicResponse> resultBasic(
        @RequestParam("numX") Integer numX,
        @RequestParam("numY") Integer numY)
    {
        ResultBasicResponse response = new ResultBasicResponse()
            .setResult(BasicResults.CALCULATION_SUCCESSFUL)
            .setSum(numX + numY);

        return ResponseEntity
            .status(response.getResult().status())
            .body(response);
    }

    @GetMapping("/result/error")
    public ResponseEntity<ResultBasicResponse> resultError(
        @RequestParam("numX") Integer numX,
        @RequestParam("numY") Integer numY)
    {
        if (numX < 0 || numY < 0) {
            throw new ResultError(BasicResults.DATA_CONTAINS_INVALID_INTEGERS);
        }

        ResultBasicResponse response = new ResultBasicResponse()
            .setResult(BasicResults.CALCULATION_SUCCESSFUL)
            .setSum(numX + numY);

        return ResponseEntity
            .status(response.getResult().status())
            .body(response);
    }

    @GetMapping("/result/extended")
    public ResponseEntity<ResultExtendedResponse> resultExtended(
        @RequestParam("numX") Integer numX,
        @RequestParam("numY") Integer numY)
    {
        if (numX < 0 || numY < 0) {
            throw new ResultError(BasicResults.DATA_CONTAINS_INVALID_INTEGERS);
        }

        ResultExtendedResponse response = new ResultExtendedResponse()
            .setResult(BasicResults.CALCULATION_SUCCESSFUL)
            .setSum(numX + numY);

        return response.toResponse();
    }
}
