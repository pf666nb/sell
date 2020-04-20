package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/13 14:10
 */
@Component
@Slf4j
@ServerEndpoint("/webSocket")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public  void onOpen(Session session){

        this.session =session;
        webSockets.add(this);
        log.info("[websocket]有新的连接总数为{}",webSockets.size());
    }
    @OnClose
    public void  onClose(){
        webSockets.remove(this);
        log.info("[websocket]连接断开连接总数{}",webSockets.size());

    }
    @OnMessage
    public void onMessage(String message){

        log.info("[webSocket]收到客户端发来的消息{}",message);
    }
    public void  senMessage(String message){

        for (WebSocket webSocket : webSockets){

            log.info("[websocket]广播消息{}",message);
            try {

                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
