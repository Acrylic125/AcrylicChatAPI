package com.acrylic.tests;

import com.acrylic.chatfunction.MainChatProcess;
import com.acrylic.exceptions.UnableToUseChatVariableException;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Test implements Listener {

    @EventHandler
    public void listenChat(AsyncPlayerChatEvent event) {
        try {
            MainChatProcess.of(event).processMessage().send(event.getPlayer());
        } catch (UnableToUseChatVariableException ex) {
            ex.printStackTrace();
        } finally {
            Bukkit.broadcastMessage("Done");
        }
    }

}
