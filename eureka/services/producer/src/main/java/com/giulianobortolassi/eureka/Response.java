package com.giulianobortolassi.eureka;

public class Response {

    String body;
    ProducerInformation producer;

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public ProducerInformation getProducer() {
        return producer;
    }

    public void setProducer(ProducerInformation producer) {
        this.producer = producer;
    }

    
    
}
