package io.github.tdminhnhat.socket;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.reactivestreams.Publisher;

@ServerWebSocket(value = "${api-path.websocket.notify}/{userId}")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotifyWebSocket {

    @OnOpen
    public Publisher<?> onOpen(@PathVariable("userId") String userId, WebSocketSession webSocketSession) {
        return null;
    }

    @OnMessage
    public Publisher<?> onMessage(@PathVariable("userId") String userId, @Body String message, WebSocketSession webSocketSession) {
        return null;
    }

    @OnClose
    public Publisher<?> onClose(@PathVariable("userId") String userId, WebSocketSession webSocketSession) {
        return null;
    }
}
