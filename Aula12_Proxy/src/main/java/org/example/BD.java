package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<String, Site> sites = new HashMap<>();

    public static Site getSite(String link) {
        return sites.get(link);
    }

    public static void addSite(Site site) {
        sites.put(site.getLink(), site);
    }
}
