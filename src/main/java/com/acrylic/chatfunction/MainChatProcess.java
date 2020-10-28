package com.acrylic.chatfunction;

import acrylic.nmsutils.json.JSON;
import com.acrylic.AcrylicChatAPI;
import com.acrylic.chatvariables.AbstractChatVariableSet;
import com.acrylic.chatvariables.ChatVariable;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MainChatProcess implements AbstractChatProcess {

    private final AsyncPlayerChatEvent event;

    private AbstractChatVariableSet<ChatVariable> chatVariableSet = AcrylicChatAPI.getChatVariableSet();
    private JSON json = new JSON();

    public static MainChatProcess of(AsyncPlayerChatEvent event) {
        return new MainChatProcess(event);
    }

    private MainChatProcess(AsyncPlayerChatEvent event) {
        this.event = event;
    }

    @Override
    public AsyncPlayerChatEvent getEvent() {
        return event;
    }

    @Override
    public AbstractChatVariableSet<ChatVariable> getChatVariableSet() {
        return chatVariableSet;
    }

    @Override
    public JSON getBaseJson() {
        return json;
    }
}
