package io.github.tdminhnhat.socket;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
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

@ServerWebSocket(value = "${api-path.websocket.group-chat}/{groupId}/{senderId}")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupChatWebSocket {

    WebSocketBroadcaster webSocketBroadcaster;

    @OnOpen
    public Publisher<?> onOpen(@PathVariable("senderId") String senderId, WebSocketSession webSocketSession) {
        return null;
    }

    @OnMessage
    public Publisher<?> onMessage(@PathVariable("groupId") String groupId, @PathVariable("senderId") String senderId, @Body String message, WebSocketSession webSocketSession) {
        return null;
    }

    @OnClose
    public Publisher<?> onClose(@PathVariable("senderId") String senderId, WebSocketSession webSocketSession) {
        return null;
    }
}
