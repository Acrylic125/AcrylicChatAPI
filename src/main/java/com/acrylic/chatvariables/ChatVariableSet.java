package com.acrylic.chatvariables;

import com.acrylic.paginatedcollection.PaginatedHashSet;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

public final class ChatVariableSet implements AbstractChatVariableSet<ChatVariable> {

    private final Set<ChatVariable> chatVariables;
    private final Pattern splittingPattern = Pattern.compile(getSplitter());

    public ChatVariableSet() {
        this(new HashSet<>());
    }

    public ChatVariableSet(@NotNull Set<ChatVariable> set) {
        this.chatVariables = set;
    }

    @Override
    public Set<ChatVariable> getSet() {
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
