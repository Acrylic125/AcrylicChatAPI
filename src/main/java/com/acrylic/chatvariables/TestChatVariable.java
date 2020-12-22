package com.acrylic.chatvariables;

import com.acrylic.chatfunction.AbstractChatProcess;
import com.acrylic.universal.NMSBridge;
import com.acrylic.universal.json.AbstractJSONComponent;
import com.acrylic.universal.json.JSONComponent;
import com.acrylic.universal.text.ChatUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

/**
 * By default, this will not be registered to any chat variable set
 * as this is an example.
 */
public class TestChatVariable implements SingleUseChatVariable {

    @Override
    public String getVariable() {
        return "[bal]";
    }

    @Override
    public AbstractJSONComponent getReplacement(@NotNull AbstractChatProcess chatProcess, @NotNull String var) {
        return NMSBridge.getBridge().getJSONComponent("&r&8[&aI am gay!&r&8]");
    }

    @Override
    public boolean allowedToUse(Player player) {
        return true;
    }

    @Override
    public void failedMultipleUses(Player player) {
        player.sendMessage(ChatUtils.get("&c&l[!] &r&cYou may only use " + getVariable() + " once per message."));
    }
}
