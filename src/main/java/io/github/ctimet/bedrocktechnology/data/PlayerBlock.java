package io.github.ctimet.bedrocktechnology.data;

import java.io.Serializable;

public class PlayerBlock implements Serializable
{
    public String playerName;
    public String blockId;

    public PlayerBlock(String aPlayerName,String aBlockId)
    {
        playerName = aPlayerName;
        blockId = aBlockId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getBlockId() {
        return blockId;
    }
}
