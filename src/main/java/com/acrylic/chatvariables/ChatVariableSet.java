package com.acrylic.chatvariables;

import com.acrylic.paginatedcollection.PaginatedHashSet;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public final class ChatVariableSet implements AbstractChatVariableSet<ChatVariable> {

    private final PaginatedHashSet<ChatVariable> chatVariables = new PaginatedHashSet<>(10);

    @Override
    public PaginatedHashSet<ChatVariable> getSet() {
        return chatVariables;
    }

    @NotNull
    @Override
    public Iterator<ChatVariable> iterator() {
        return chatVariables.iterator();
    }
}
