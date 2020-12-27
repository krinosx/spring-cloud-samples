package com.giulianobortolassi.eureka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 */
@RestController
public class Controller {
    
    @Autowired
    DiscoveryClient discoveryClient;
    
    @Autowired
    Environment environment;

    private String hostname;
    
    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String serviceName;
    

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> listInstances( @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/greet")
    public Response greet() {


        this.hostname = environment.getProperty("server.address");

        Response response = new Response();
        response.setBody("Hello from a producer");
        response.setProducer(new ProducerInformation(this.hostname, this.port, this.serviceName));

        return response;
    }
    
}