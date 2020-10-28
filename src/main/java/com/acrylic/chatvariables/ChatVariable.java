package com.acrylic.chatvariables;

import acrylic.nmsutils.json.AbstractJSONComponent;
import org.bukkit.entity.Player;

public interface ChatVariable {

    /**
     * The variable. For example, [item]
     * MAKE SURE THIS IS ALL LOWERCASE!
     */
    String getVariable();

    AbstractJSONComponent getReplacement(Player player);

    boolean allowedToUse(Player player);

    boolean multipleUses();

    void failedMultipleUses(Player player);

}
