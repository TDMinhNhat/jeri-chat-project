package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.Address;
import io.github.tdminhnhat.model.dto.AddressDTO;
import io.github.tdminhnhat.model.vo.AddressVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface AddressMapper {

    Address toEntity(AddressDTO request);

    AddressVO toVO(Address address);
}
