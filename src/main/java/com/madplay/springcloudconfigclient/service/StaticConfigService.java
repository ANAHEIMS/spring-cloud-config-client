package com.madplay.springcloudconfigclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author madplay
 */
@Service
public class StaticConfigService {

    @Value("${taeng.profile}")
    private String profile;
    @Value("${taeng.comment}")
    private String comment;
    @Value("${taeng.change}")
    private String change;

    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("profile", profile);
        map.put("comment", comment);
        map.put("change", change);
        return map;
    }
}