package com.acrylic.tests;

import com.acrylic.chatfunction.MainChatProcess;
import com.acrylic.exceptions.UnableToUseChatVariableException;
import com.acrylic.universal.json.JSON;
import com.acrylic.universal.json.JSONComponent;
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
                        jsonComponent.subText("&7Raw Message:", event.getMessage());
                    });
            chatProcess
                    .setJSON(new JSON(JSONComponent.of("&c&l" + event.getPlayer().getName() + " &8&l> ")))
                    .setChatFormat("&c")
                    .processMessage()
                    .sendAll(ServerOperator::isOp);
            chatProcess
                    .setJSON(new JSON(JSONComponent.of("&f" + event.getPlayer().getName() + " &8&l> ")))
                    .setChatFormat("&7")
                    .processMessage()
                    .sendAll();
        } catch (UnableToUseChatVariableException ex) {
            ex.printStackTrace();
        }
    }

}
