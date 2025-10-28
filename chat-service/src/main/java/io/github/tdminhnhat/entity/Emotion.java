package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "emotions")
@Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Emotion extends BaseEntity {

    @MappedProperty(value = "emotion_name", type = DataType.STRING)
    String emotionName;

    @MappedProperty(value = "icon_url", type = DataType.STRING)
    String iconUrl;

    public Emotion(String iconUrl, String emotionName) {
        super();
        this.iconUrl = iconUrl;
        this.emotionName = emotionName;
    }
}
