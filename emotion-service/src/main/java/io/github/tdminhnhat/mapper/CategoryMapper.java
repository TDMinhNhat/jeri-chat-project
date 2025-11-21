package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.Category;
import io.github.tdminhnhat.model.dto.CategoryDTO;
import io.github.tdminhnhat.model.vo.CategoryVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface CategoryMapper {

    Category toEntity(CategoryDTO request);

    CategoryVO toVO(Category category);
}
