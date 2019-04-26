package io.dddbyexamples.comandcontrol;

import java.util.HashMap;
import java.util.Map;

public class Aliases<ID> {

    private final Map<String, ID> aliases = new HashMap<>();

    public void put(String alias, ID objectID) {
        aliases.put(alias, objectID);
    }

    public ID of(String alias) {
        if (!aliases.containsKey(alias)) {
            throw new IllegalArgumentException("alias '" + alias + "' not defined in " + aliases);
        }
        return aliases.get(alias);
    }
}
