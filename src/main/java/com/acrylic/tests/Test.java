package com.acrylic.tests;

import acrylic.nmsutils.json.JSON;
import acrylic.nmsutils.json.JSONComponent;
import com.acrylic.chatfunction.MainChatProcess;
import com.acrylic.exceptions.UnableToUseChatVariableException;
import com.acrylic.version_latest.Messages.Symbols;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.permissions.ServerOperator;

public class Test implements Listener {

    @EventHandler
    public void listenChat(AsyncPlayerChatEvent event) {
        try {
            MainChatProcess chatProcess = MainChatProcess.of(event)
                    .modifyMessageComponent(jsonComponent -> {
                        jsonComponent.subText("&7Raw Message:",event.getMessage());
                    });
            chatProcess
                    .setJSON(new JSON(JSONComponent.of("&c&l" + event.getPlayer().getName() + " &8&l" + Symbols.DOUBLE_ARROW_RIGHT.getSymbol() + " ")))
                    .setChatFormat("&c")
                    .processMessage()
                    .sendAll(ServerOperator::isOp);
            chatProcess
                    .setJSON(new JSON(JSONComponent.of("&f" + event.getPlayer().getName() + " &8&l" + Symbols.DOUBLE_ARROW_RIGHT.getSymbol() + " ")))
                    .setChatFormat("&7")
                    .processMessage()
                    .sendAll();
        } catch (UnableToUseChatVariableException ex) {
            ex.printStackTrace();
        }
    }

}
