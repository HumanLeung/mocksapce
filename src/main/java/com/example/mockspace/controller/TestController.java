package com.example.mockspace.controller;/*
 *@program:MockSpace
 *@author: liangxm
 *@Time: 2023/4/20  21:44
 *@description:
 */

import com.example.mockspace.dto.DeliveryAssignmentDto;
import com.example.mockspace.dto.DeliveryAssignmentItemDto;
import com.example.mockspace.entity.DeliveryAssignment;
import com.example.mockspace.entity.DeliveryAssignmentItem;
import com.example.mockspace.excel.vo.DavcoExcelService;
import com.example.mockspace.excel.vo.DeliveryAssignmentItemVo;
import com.example.mockspace.excel.vo.DeliveryAssignmentVo;
import com.example.mockspace.excel.vo.mapper.VoMapper;
import com.example.mockspace.mapper.DeliveryAssignmentMapper;
import com.example.mockspace.repository.DeliveryAssignmentRepository;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    DeliveryAssignmentRepository deliveryAssignmentRepository;

    @Autowired
    DeliveryAssignmentMapper mapper;

    @Autowired
    VoMapper voMapper;

    @Autowired
    DavcoExcelService davcoExcelService;

    @GetMapping("/t1")
    public void test(HttpServletResponse response){
       Pageable pageable = PageRequest.of(0,2);
        Page<DeliveryAssignment> entities = deliveryAssignmentRepository.findAll(pageable);
        Page<DeliveryAssignmentDto> dtoList = entities.map(mapper::toDto);
        List<DeliveryAssignmentDto> list = dtoList.getContent();

        List<DeliveryAssignmentVo> vos = voMapper.toVoList(list);
        List<DeliveryAssignmentItemDto> itemDtoList = list.stream()
                .map(DeliveryAssignmentDto::getItems)
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());

        List<DeliveryAssignmentItemVo> itemVos = voMapper.toItemList(itemDtoList);

        for(DeliveryAssignmentItemVo itemVo : itemVos){
            for (DeliveryAssignmentVo vo : vos){
                if (itemVo.getAssignmentId().equals(vo.getId())){
                    itemVo.setNo(vo.getNo());
                }
            }
        }

        Workbook wb = davcoExcelService.buildWorkbook("单据主体","出货安排单子表",DeliveryAssignmentVo.class,
               vos,DeliveryAssignmentItemVo.class,itemVos);
        davcoExcelService.downloadExcel(response,"asd",wb);
    }

}
