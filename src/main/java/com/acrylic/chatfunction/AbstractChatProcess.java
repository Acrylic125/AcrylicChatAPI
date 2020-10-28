package com.acrylic.chatfunction;

import acrylic.nmsutils.json.JSON;
import com.acrylic.chatvariables.AbstractChatVariableSet;
import com.acrylic.chatvariables.ChatVariable;
import com.acrylic.exceptions.UnableToUseChatVariableException;
import jdk.internal.net.http.common.Pair;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;

public interface AbstractChatProcess {

    AsyncPlayerChatEvent getEvent();

    AbstractChatVariableSet<ChatVariable> getChatVariableSet();

    JSON getBaseJson();

    default JSON process(String chatFormat) throws UnableToUseChatVariableException {
        JSON json = getBaseJson();
        String[] deconstructed = getAnalyzableMessage();
        Player player = getPlayer();

        HashSet<ChatVariable> used = new HashSet<>();
        for (String var : deconstructed) {
            for (ChatVariable chatVariable : getChatVariableSet()) {
                if (chatVariable.getVariable().equalsIgnoreCase(var)) {
                    if (!chatVariable.allowedToUse(player)) {
                        
                    } else if (!chatVariable.multipleUses() && used.contains(chatVariable)) {

                    } else {
                        used.add(chatVariable);
                    }
                }
            }
        }
        return json;
    }

    default String[] getAnalyzableMessage() {
        return getMessage().split(" ");
    }

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
