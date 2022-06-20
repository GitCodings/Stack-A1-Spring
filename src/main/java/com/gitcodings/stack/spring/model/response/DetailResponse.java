package com.gitcodings.stack.spring.model.response;

public class DetailResponse
{
   private Integer number;
   private Double square;
   private Double cube;
   private Double root;
   private Boolean negative;

    public Integer getNumber()
    {
        return number;
    }

    public DetailResponse setNumber(Integer number)
    {
        this.number = number;
        return this;
    }

    public Double getSquare()
    {
        return square;
    }

    public DetailResponse setSquare(Double square)
    {
        this.square = square;
        return this;
    }

    public Double getCube()
    {
        return cube;
    }

    public DetailResponse setCube(Double cube)
    {
        this.cube = cube;
        return this;
    }

    public Double getRoot()
    {
        return root;
    }

    public DetailResponse setRoot(Double root)
    {
        this.root = root;
        return this;
    }

    public Boolean getNegative()
    {
        return negative;
    }

    public DetailResponse setNegative(Boolean negative)
    {
        this.negative = negative;
        return this;
    }
}
