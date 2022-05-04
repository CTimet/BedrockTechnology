package io.github.ctimet.bedrocktechnology.data;

import java.io.Serializable;

public class Map implements Serializable
{
    public String s01;
    public PlayerBlock s02;

    public Map(String s1, PlayerBlock s2)
    {
        s01 = s1;
        s02 = s2;
    }

    public String getS01()
    {
        return s01;
    }

    public PlayerBlock getS02()
    {
        return s02;
    }
}
