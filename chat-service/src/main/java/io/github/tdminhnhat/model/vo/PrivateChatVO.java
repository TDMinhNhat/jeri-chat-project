package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;

@Serdeable
@SerdeImport
@Introspected
@Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivateChatVO extends BaseVO {
    Long friendId;

    Long senderId;

    String message;

    Boolean isRecall;

    Flux<PrivateChatEmotionVO> privateChatEmotionVO;
}
