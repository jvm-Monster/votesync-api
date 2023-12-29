package com.vi.votesyncapi.util;

import jakarta.persistence.PersistenceUnitUtil;

public class AppPersistentUtil implements PersistenceUnitUtil {
    @Override
    public boolean isLoaded(Object o, String s) {
        
        return false;
    }

    @Override
    public boolean isLoaded(Object o) {
        return false;
    }

    @Override
    public Object getIdentifier(Object o) {
        return null;
    }
}
