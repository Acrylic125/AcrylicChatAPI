package com.acrylic.chatvariables;

import org.bukkit.entity.Player;

public interface SingleUseChatVariable extends ChatVariable {

    void failedMultipleUses(Player player);

}
