package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.Address;
import io.github.tdminhnhat.model.dto.AddressDTO;
import io.github.tdminhnhat.model.vo.AddressVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface AddressMapper {

    Address toEntity(AddressDTO request);

    AddressVO toVO(Address address);

    Address updateFromDTO(AddressDTO request, Address address);
}
