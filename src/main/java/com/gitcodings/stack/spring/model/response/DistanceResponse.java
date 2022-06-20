package com.gitcodings.stack.spring.model.response;

public class DistanceResponse
{
    private String point1;
    private String point2;

    private Double distance;

    public String getPoint1()
    {
        return point1;
    }

    public DistanceResponse setStart(String point1)
    {
        this.point1 = point1;
        return this;
    }

    public String getPoint2()
    {
        return point2;
    }

    public DistanceResponse setEnd(String point2)
    {
        this.point2 = point2;
        return this;
    }

    public Double getDistance()
    {
        return distance;
    }

    public DistanceResponse setDistance(Double distance)
    {
        this.distance = distance;
        return this;
    }
}
