package com.acrylic.chatvariables;

import acrylic.nmsutils.json.AbstractJSONComponent;
import com.acrylic.chatfunction.AbstractChatProcess;
import org.bukkit.entity.Player;

public interface ChatVariable {

    /**
     * The variable. For example, [item]
     * MAKE SURE THIS IS ALL LOWERCASE!
     */
    String getVariable();

    AbstractJSONComponent getReplacement(AbstractChatProcess chatProcess);

    boolean allowedToUse(Player player);

}
