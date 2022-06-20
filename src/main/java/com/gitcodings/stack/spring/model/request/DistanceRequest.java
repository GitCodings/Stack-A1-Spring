package com.gitcodings.stack.spring.model.request;

import com.gitcodings.stack.spring.model.data.Point;

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
