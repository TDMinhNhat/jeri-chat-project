package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.Emotion;
import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface EmotionMapper {

    Emotion toEntity(EmotionDTO request);

    EmotionVO toVO(Emotion entity);
}
