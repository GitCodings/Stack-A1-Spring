package com.gitcodings.stack.spring.model.response;

public class CuboidResponse
{
    private String cubiod;
    private Integer surfaceArea;
    private Integer volume;

    public String getCubiod()
    {
        return cubiod;
    }

    public CuboidResponse setCubiod(String cubiod)
    {
        this.cubiod = cubiod;
        return this;
    }

    public Integer getSurfaceArea()
    {
        return surfaceArea;
    }

    public CuboidResponse setSurfaceArea(Integer surfaceArea)
    {
        this.surfaceArea = surfaceArea;
        return this;
    }

    public Integer getVolume()
    {
        return volume;
    }

    public CuboidResponse setVolume(Integer volume)
    {
        this.volume = volume;
        return this;
    }
}
