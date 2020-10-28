package com.acrylic.chatfunction;

import acrylic.nmsutils.json.JSON;
import com.acrylic.chatvariables.AbstractChatVariableSet;
import com.acrylic.chatvariables.ChatVariable;
import com.acrylic.exceptions.UnableToUseChatVariableException;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public interface BaseChatProcess {

    AsyncPlayerChatEvent getEvent();

    AbstractChatVariableSet<ChatVariable> getChatVariableSet();

    JSON getBaseJson();

    default Player getPlayer() {
        return getEvent().getPlayer();
    }

    default String getMessage() {
        return getEvent().getMessage();
    }

    default void throwFailedVariable(ChatVariable chatVariable) throws UnableToUseChatVariableException {
        throw new UnableToUseChatVariableException(chatVariable,getPlayer());
    }

}
