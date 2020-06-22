package com.tw.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "EMAIL-SERVICE", fallback = EmailServiceClient.EmailServiceFallback.class)
interface EmailServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/email/{userName}")
    String getEmail(@PathVariable(value = "userName") String userName);

    @Component
    class EmailServiceFallback implements EmailServiceClient {
        @Override
        public String getEmail(String userName) {
            return userName + "@error.com";
        }
    }

}
