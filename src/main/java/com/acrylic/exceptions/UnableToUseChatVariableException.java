package com.acrylic.exceptions;

import com.acrylic.chatvariables.ChatVariable;
import org.bukkit.entity.Player;

public class UnableToUseChatVariableException extends Exception {

    private final ChatVariable chatVariable;
    private final Player player;

    public UnableToUseChatVariableException(ChatVariable chatVariable, Player player) {
        this.chatVariable = chatVariable;
        this.player = player;
    }

    @Override
    public String toString() {
        return "UnableToUseChatVariableException: " + player.getName() + " is not able to use " + chatVariable.getVariable() + ".";
    }
}
