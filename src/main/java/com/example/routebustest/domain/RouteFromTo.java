package com.example.routebustest.domain;

public class RouteFromTo {

    private Integer from;
    private Integer To;
    private boolean direct;

    public RouteFromTo(Integer from, Integer to, boolean direct) {
        this.from = from;
        To = to;
        this.direct = direct;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return To;
    }

    public void setTo(Integer to) {
        To = to;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }
}
