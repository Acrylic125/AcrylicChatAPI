package com.acrylic.chatfunction;

import acrylic.nmsutils.json.AbstractJSONComponent;
import acrylic.nmsutils.json.JSON;
import acrylic.nmsutils.json.JSONComponent;
import com.acrylic.chatvariables.ChatVariable;
import com.acrylic.exceptions.UnableToUseChatVariableException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.function.Consumer;

public interface AbstractChatProcess extends BaseChatProcess {

    String chatFormat();

    Consumer<AbstractJSONComponent> messageComponentConsumer();

    default JSON processMessage() throws UnableToUseChatVariableException {
        final JSON json = getBaseJson();
        final String[] deconstructed = getAnalyzableMessage();
        final Player player = getPlayer();
        final String splitAt = getChatVariableSet().getSplitter();

        HashSet<ChatVariable> used = new HashSet<>();
        int i = 0;
        stringDeconstructedLoop: for (String var : deconstructed) {
            for (ChatVariable chatVariable : getChatVariableSet()) {
                if (chatVariable.getVariable().equalsIgnoreCase(var)) {
                    if (!chatVariable.allowedToUse(player)) {
                        break;
                    } else if (!chatVariable.multipleUses() && used.contains(chatVariable)) {
                        throwFailedVariable(chatVariable);
                        break;
                    } else {
                        appendVariable(json,chatVariable);
                        used.add(chatVariable);
                        continue stringDeconstructedLoop;
                    }
                }
            }
            //
            if (i > 0) {
                append(json,splitAt + var);
            } else {
                append(json,var);
            }
            i++;
        }
        return json;
    }

    default void appendVariable(JSON json, ChatVariable chatVariable) {
        json.append(chatVariable.getReplacement(this))
            .append(JSONComponent.of(chatFormat()));
    }

    default void append(JSON json, String text) {
        JSONComponent comp = JSONComponent.of(text);
        Consumer<AbstractJSONComponent> componentConsumer = messageComponentConsumer();
        if (componentConsumer != null) componentConsumer.accept(comp);
        json.append(comp);
    }

    default String[] getAnalyzableMessage() {
        return getMessage().split(getChatVariableSet().getSplitter());
    }


}
