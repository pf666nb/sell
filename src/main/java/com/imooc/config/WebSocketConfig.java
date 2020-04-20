package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/13 14:08
 */
@Component
public class WebSocketConfig {

        @Bean
        public ServerEndpointExporter serverEndpointExporter(){
            return new ServerEndpointExporter();
    }
}
