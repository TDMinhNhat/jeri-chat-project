package io.github.tdminhnhat.socket;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.reactivestreams.Publisher;

@ServerWebSocket(value = "${api-path.websocket.private-chat}/{senderId}")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PrivateChatWebSocket {

    WebSocketBroadcaster webSocketBroadcaster;

    @OnOpen
    public Publisher<?> onOpen(String senderId, WebSocketSession webSocketSession) {
        return null;
    }

    @OnMessage
    public Publisher<?> onMessage(String receiverId, String senderId, String message, WebSocketSession webSocketSession) {
        return null;
    }

    @OnClose
    public Publisher<?> onClose(String senderId, WebSocketSession webSocketSession) {
        return null;
    }
}
