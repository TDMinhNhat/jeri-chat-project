package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.Emotion;
import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface EmotionMapper {

    @Mapper.Mapping(to = "deleted", defaultValue = "false")
    Emotion toEntity(EmotionDTO request);

    EmotionVO toVO(Emotion entity);
}
