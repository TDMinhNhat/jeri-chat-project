package io.github.tdminhnhat.model.vo;

import io.github.tdminhnhat.enums.FriendStatus;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Serdeable
@SerdeImport
@Introspected
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class FriendVO extends BaseVO {
    private Long senderId;

    private Long userId;

    private String messageRequest;

    private FriendStatus status;
}
