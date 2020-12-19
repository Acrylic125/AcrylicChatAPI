package com.acrylic.chatvariables;

import com.acrylic.paginatedcollection.PaginatedHashSet;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.regex.Pattern;

public final class ChatVariableSet implements AbstractChatVariableSet<ChatVariable> {

    private final PaginatedHashSet<ChatVariable> chatVariables = new PaginatedHashSet<>(10);
    private final Pattern splittingPattern = Pattern.compile(getSplitter());

    @Override
    public PaginatedHashSet<ChatVariable> getSet() {
        return chatVariables;
    }

    @Override
    public String getSplitter() {
        return " ";
    }

    @Override
    public Pattern getSplittingPattern() {
        return splittingPattern;
    }

    @NotNull
    @Override
    public Iterator<ChatVariable> iterator() {
        return chatVariables.iterator();
    }
}
