package com.github.klefstad_teaching.cs122b.spring.model.request;

import com.github.klefstad_teaching.cs122b.spring.model.data.Point;

public class DistanceRequest
{
   private Point start;
   private Point end;

    public Point getStart()
    {
        return start;
    }

    public DistanceRequest setStart(Point start)
    {
        this.start = start;
        return this;
    }

    public Point getEnd()
    {
        return end;
    }

    public DistanceRequest setEnd(Point end)
    {
        this.end = end;
        return this;
    }
}
