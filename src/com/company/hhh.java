package com.company;

public class hhh {

    private String a;
    private boolean b;
    private int c;

    public hhh(String a,boolean b,int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public int getC(){
        return c;

    }
    public static int compare(hhh h1, hhh h2)
    {
        if(h1.getC()>h2.getC())
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "hhh{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
