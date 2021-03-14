package com.madplay.springcloudconfigclient.controller;

import com.madplay.springcloudconfigclient.service.DynamicConfigService;
import com.madplay.springcloudconfigclient.service.StaticConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author madplay
 */
@RestController /* JSON 형태로 객체를 반환하기 위한 어노테이션 */
public class ConfigController {

    private final StaticConfigService configStaticService;
    private final DynamicConfigService configDynamicService;

    @Autowired /* 생성자 주입, 단일 생성자여서 어노테이션을 제외해도 되긴하다. */
    public ConfigController(StaticConfigService configStaticService, DynamicConfigService configDynamicService) {
        this.configStaticService = configStaticService;
        this.configDynamicService = configDynamicService;
    }

    /* @GetMapping 어노테이션은 다음과도 같음 */
    /* @RequestMapping(value="/static", method = { RequestMethod.GET} */
    @GetMapping(value = "/static")
    public Object getConfigFromStatic() {
        return configStaticService.getConfig();
    }

    /* @GetMapping 어노테이션은 다음과도 같음 */
    /* @RequestMapping(value="/dynamic", method = { RequestMethod.GET} */
    @GetMapping(value = "/dynamic")
    public Object getConfigFromDynamic() {
        return configDynamicService.getConfig();
    }
}