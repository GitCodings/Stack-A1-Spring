package com.gitcodings.stack.spring.model.request;

public class CuboidRequest
{
    private Integer length;
    private Integer width;
    private Integer height;

    public Integer getLength()
    {
        return length;
    }

    public CuboidRequest setLength(Integer length)
    {
        this.length = length;
        return this;
    }

    public Integer getWidth()
    {
        return width;
    }

    public CuboidRequest setWidth(Integer width)
    {
        this.width = width;
        return this;
    }

    public Integer getHeight()
    {
        return height;
    }

    public CuboidRequest setHeight(Integer height)
    {
        this.height = height;
        return this;
    }

    @Override
    public String toString()
    {
        return String.format("(%dL, %dW, %dH)", length, width, height);
    }
}
