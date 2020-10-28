package com.acrylic.exceptions;

import com.acrylic.chatvariables.ChatVariable;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class UnableToUseChatVariableException extends Exception {

    private final ChatVariable chatVariable;
    private final Player player;

    @Override
    public String toString() {
        return player.getName() + " is not able to use " + chatVariable.getVariable();
    }
}
