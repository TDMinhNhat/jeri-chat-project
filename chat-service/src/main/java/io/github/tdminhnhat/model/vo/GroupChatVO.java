package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;

@Serdeable
@SerdeImport
@Introspected
@Data @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupChatVO extends BaseVO {
    Long groupId;

    Long senderId;

    String message;

    Boolean isRecall;

    Flux<GroupChatEmotionVO> groupChatEmotionVO;
}
