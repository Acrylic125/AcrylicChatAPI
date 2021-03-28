package com.acrylic.chatvariables;

import com.acrylic.chatfunction.AbstractChatProcess;
import com.acrylic.universal.items.ItemUtils;
import com.acrylic.universal.text.ChatUtils;
import com.acrylic.universalnms.json.JSONComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * By default, this will not be registered to any chat variable set
 * as this is an example.
 */
public class ItemChatVariable implements SingleUseChatVariable {

    @Override
    public String getVariable() {
        return "[item]";
    }

    @Override
    public JSONComponent getReplacement(@NotNull AbstractChatProcess chatProcess, @NotNull String var) {
        ItemStack item = chatProcess.getPlayer().getItemInHand();
        return JSONComponent.of("&r&8[" + ItemUtils.getNameWithAmount(item) + "&r&8]")
                .item(item);
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
