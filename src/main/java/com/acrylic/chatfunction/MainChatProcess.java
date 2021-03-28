package com.acrylic.chatfunction;

import com.acrylic.AcrylicChatAPI;
import com.acrylic.chatvariables.AbstractChatVariableSet;
import com.acrylic.chatvariables.ChatVariable;
import com.acrylic.universalnms.json.AbstractJSONComponent;
import com.acrylic.universalnms.json.JSON;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.function.Consumer;

public final class MainChatProcess implements AbstractChatProcess {

    private final AsyncPlayerChatEvent event;

    private AbstractChatVariableSet<ChatVariable> chatVariableSet = AcrylicChatAPI.getChatVariableSet();
    private JSON json = new JSON();
    private String chatFormat = "&7";
    private Consumer<AbstractJSONComponent> messageComponentConsumer = null;

    public static MainChatProcess of(AsyncPlayerChatEvent event) {
        return new MainChatProcess(event);
    }

    private MainChatProcess(AsyncPlayerChatEvent event) {
        this.event = event;
    }

    public MainChatProcess setJSON(JSON json) {
        this.json = json;
        return this;
    }

    public MainChatProcess setChatVariableSet(AbstractChatVariableSet<ChatVariable> chatVariableSet) {
        this.chatVariableSet = chatVariableSet;
        return this;
    }

    public MainChatProcess modifyMessageComponent(Consumer<AbstractJSONComponent> messageComponentConsumer) {
        this.messageComponentConsumer = messageComponentConsumer;
        return this;
    }

    public MainChatProcess setChatFormat(String chatFormat) {
        this.chatFormat = chatFormat;
        return this;
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

    @Override
    public String chatFormat() {
        return chatFormat;
    }

    @Override
    public Consumer<AbstractJSONComponent> messageComponentConsumer() {
        return messageComponentConsumer;
    }
}
