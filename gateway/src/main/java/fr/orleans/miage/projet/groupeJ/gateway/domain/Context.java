package fr.orleans.miage.projet.groupeJ.gateway.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Context {

    private final Map<String, Collection<Object>> values = new HashMap<>();

    public void put( String key, Collection<Object> value ) {
        values.put( key, value );
    }

    public Object get( String key ) {
        return values.get( key );
    }
}
