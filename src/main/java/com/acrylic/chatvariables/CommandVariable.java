package com.acrylic.chatvariables;

import com.acrylic.chatfunction.AbstractChatProcess;
import com.acrylic.universal.NMSBridge;
import com.acrylic.universal.items.ItemUtils;
import com.acrylic.universal.json.AbstractJSONComponent;
import com.acrylic.universal.json.JSONComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class CommandVariable implements ChatVariable {

    private static final Pattern COMMAND_IDENTIFIER_HEAD = Pattern.compile("\\[/");
    private static final Pattern COMMAND_IDENTIFIER_TAIL = Pattern.compile("]");
    private static final Pattern COMMAND_SLICER = Pattern.compile("_");

    @Override
    public String getVariable() {
        return "[/???]";
    }

    @Override
    public AbstractJSONComponent getReplacement(@NotNull AbstractChatProcess chatProcess, @NotNull String var) {
        var = COMMAND_SLICER.matcher(var).replaceAll(" ");
        var = COMMAND_IDENTIFIER_HEAD.matcher(var).replaceFirst("");
        var = COMMAND_IDENTIFIER_TAIL.matcher(var).replaceFirst("");
        var = "/" + var;
        NMSBridge bridge = NMSBridge.getBridge();
        return bridge.getJSONComponent("&8[&e" + var + "&r&8]").suggestCommand(var).subText("&7Click to copy the command:", "&e" + var);
     }

    @Override
    public boolean allowedToUse(Player player) {
        return player.isOp();
    }

    @Override
    public boolean isThisVariable(@NotNull String var) {
        return COMMAND_IDENTIFIER_HEAD.matcher(var).find() && COMMAND_IDENTIFIER_TAIL.matcher(var).find();
    }
}
