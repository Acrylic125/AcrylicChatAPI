package com.acrylic.chatvariables;

import com.acrylic.chatfunction.AbstractChatProcess;
import com.acrylic.universal.text.ChatUtils;
import com.acrylic.universalnms.json.JSONComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
    public JSONComponent getReplacement(@NotNull AbstractChatProcess chatProcess, @NotNull String var) {
        return JSONComponent.of("&r&8[&aI am gay!&r&8]");
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
