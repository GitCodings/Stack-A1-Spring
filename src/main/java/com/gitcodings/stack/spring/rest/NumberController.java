package com.gitcodings.stack.spring.rest;

import com.gitcodings.stack.spring.model.request.CuboidRequest;
import com.gitcodings.stack.spring.model.data.Point;
import com.gitcodings.stack.spring.model.request.DistanceRequest;
import com.gitcodings.stack.spring.model.response.CuboidResponse;
import com.gitcodings.stack.spring.model.response.DetailResponse;
import com.gitcodings.stack.spring.model.response.DistanceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController
{
    @GetMapping("/number/detail/{number}")
    public ResponseEntity<DetailResponse> detail(
        @PathVariable Integer number)
    {
        DetailResponse body = new DetailResponse()
            .setNumber(number)
            .setSquare(Math.pow(number, 2))
            .setCube(Math.pow(number, 3))
            .setRoot(Math.sqrt(number))
            .setNegative(number < 0);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(body);
    }

    @PostMapping("/number/cuboid")
    public ResponseEntity<CuboidResponse> cuboid(
        @RequestBody CuboidRequest request)
    {
        CuboidResponse body = new CuboidResponse()
            .setCubiod(request.toString())
            .setSurfaceArea(
                (
                    request.getLength() * request.getWidth() +
                    request.getWidth() * request.getHeight() +
                    request.getHeight() * request.getLength()
                ) * 2
            )
            .setVolume(
                request.getLength() *
                request.getWidth() *
                request.getHeight()
            );

        return ResponseEntity.status(HttpStatus.OK)
                             .body(body);
    }

    @PostMapping("/number/distance")
    public ResponseEntity<DistanceResponse> detail(
        @RequestBody DistanceRequest request)
    {
        Point start = request.getStart();
        Point end   = request.getEnd();

        DistanceResponse body =
            new DistanceResponse()
                .setStart(start.toString())
                .setEnd(end.toString())
                .setDistance(
                    Math.sqrt(
                        Math.pow(end.getX() - start.getX(), 2) +
                        Math.pow(end.getY() - start.getY(), 2)
                    )
                );

        return ResponseEntity.status(HttpStatus.OK)
                             .body(body);
    }
}
