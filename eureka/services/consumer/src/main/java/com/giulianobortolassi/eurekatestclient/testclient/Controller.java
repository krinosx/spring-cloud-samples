package com.giulianobortolassi.eurekatestclient.testclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controller
 */
@RestController
public class Controller {

    @Autowired
    RestTemplate template;

    @RequestMapping("/test/{serviceName}")
    public String Test(@PathVariable String serviceName) {
        String resultado = template.getForObject("http://"+serviceName+"/greet", String.class);
        return resultado;
    }    
}