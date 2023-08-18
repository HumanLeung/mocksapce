package com.example.mockspace.excel.vo.mapper;/*
 *@program:MockSpace
 *@author: liangxm
 *@Time: 2023/4/20  22:14
 *@description:
 */

import com.example.mockspace.dto.DeliveryAssignmentDto;
import com.example.mockspace.dto.DeliveryAssignmentItemDto;
import com.example.mockspace.excel.vo.DeliveryAssignmentItemVo;
import com.example.mockspace.excel.vo.DeliveryAssignmentVo;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class VoMapper {

    public abstract DeliveryAssignmentVo toVo(DeliveryAssignmentDto dto);

    public abstract DeliveryAssignmentItemVo toItemVo(DeliveryAssignmentItemDto dto);

    public List<DeliveryAssignmentVo> toVoList(List<DeliveryAssignmentDto> dtoList){
        if (dtoList == null){
            return new ArrayList<>();
        }
        List<DeliveryAssignmentVo> result = new ArrayList<>(dtoList.size());
        int index = 1;
        for (DeliveryAssignmentDto dto : dtoList){
            DeliveryAssignmentVo vo = toVo(dto);
            vo.setNo(index++);
            result.add(vo);
        }
        return result;
    }

    public List<DeliveryAssignmentItemVo> toItemList(List<DeliveryAssignmentItemDto> itemDtoList){
        if (itemDtoList == null){
            return new ArrayList<>();
        }
        List<DeliveryAssignmentItemVo> result = new ArrayList<>(itemDtoList.size());
        for (DeliveryAssignmentItemDto itemDto : itemDtoList){
              DeliveryAssignmentItemVo itemVo = toItemVo(itemDto);
              result.add(itemVo);
        }
        return result;
    }


}
