package com.giulianobortolassi.eureka;

public class ProducerInformation {

    private final String instanceName;
    private final String hostPort;
    private final String serviceName;

    ProducerInformation(String instanceName, String hostPort, String serviceName)
    {
        this.instanceName = instanceName;
        this.hostPort = hostPort;
        this.serviceName = serviceName;
    }


    public String getHostPort() {
        return hostPort;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
