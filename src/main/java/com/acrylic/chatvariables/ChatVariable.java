package com.acrylic.chatvariables;

import com.acrylic.chatfunction.AbstractChatProcess;
import com.acrylic.universal.json.AbstractJSONComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface ChatVariable {

    /**
     * The variable. For example, item
     * MAKE SURE THIS IS ALL LOWERCASE!
     */
    String getVariable();

    AbstractJSONComponent getReplacement(@NotNull AbstractChatProcess chatProcess, @NotNull String var);

    boolean allowedToUse(Player player);

    default boolean isThisVariable(@NotNull String var) {
        return getVariable().equalsIgnoreCase(var);
    }

}
