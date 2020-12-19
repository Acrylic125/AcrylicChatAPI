package com.acrylic.chatvariables;

import com.acrylic.paginatedcollection.PaginatedHashSet;

import java.util.regex.Pattern;

/**
 * This is the main chat variable cache.
 */
public interface AbstractChatVariableSet<T extends ChatVariable>
        extends Iterable<T> {

    PaginatedHashSet<T> getSet();

    String getSplitter();

    Pattern getSplittingPattern();

    default void register(T chatVariable) {
        getSet().add(chatVariable);
    }

    default void unregister(T chatVariable) {
        getSet().remove(chatVariable);
    }

    default void unregister(String chatVariable) {
        for (T t : getSet()) {
            if (t.getVariable().equals(chatVariable)) {
                unregister(t);
                break;
            }
        }
    }

}
