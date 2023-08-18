package com.example.mockspace.mapper;

import com.example.mockspace.dto.DeliveryAssignmentItemDto;
import com.example.mockspace.entity.DeliveryAssignmentItem;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author lanjzh
 */
@Mapper(componentModel = "spring")
public interface DeliveryAssignmentItemMapper {

    @Mapping(source = "assignment.id", target = "assignmentId")
    DeliveryAssignmentItemDto toDto(DeliveryAssignmentItem entity);

}
