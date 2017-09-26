package com.art2cat.dev.effective_java.chapter2.p01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rorschach
 * on 2017/2/9.
 */
class Services {

    private Services() {
    }

    private static final Map<String, Provider> providers =
            new ConcurrentHashMap<String, Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "<DEF>";

    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    private static void registerProvider(String name, Provider p) {
        providers.put(name, p);

    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }
}
