package com.acrylic.chatvariables;

import com.acrylic.paginatedcollection.PaginatedHashSet;

/**
 * This is the main chat variable cache.
 */
public interface AbstractChatVariableSet<T extends ChatVariable> extends Iterable<T> {

    PaginatedHashSet<T> getSet();

    String getSplitter();

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
