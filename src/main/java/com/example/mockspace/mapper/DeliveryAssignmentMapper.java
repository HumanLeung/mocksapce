package com.example.mockspace.mapper;

import com.example.mockspace.dto.DeliveryAssignmentDto;
import com.example.mockspace.entity.DeliveryAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author lanjzh
 */
@Mapper(componentModel = "spring", uses = DeliveryAssignmentItemMapper.class)
public interface DeliveryAssignmentMapper {

    @Mapping(source = "tracingFields.createdAt", target = "createdAt")
    @Mapping(source = "tracingFields.updatedAt", target = "updatedAt")
    @Mapping(source = "tracingFields.createdBy", target = "createdBy")
    @Mapping(source = "tracingFields.updatedBy", target = "updatedBy")
    DeliveryAssignmentDto toDto(DeliveryAssignment entity);


}
