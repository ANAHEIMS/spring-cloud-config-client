package com.madplay.springcloudconfigclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author madplay
 */
@Service
@RefreshScope /* Spring Cloud Config 에서 변경사항을 자동으로 갱신하도록 설정 */
public class DynamicConfigService {

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