package com.example.mockspace.excel.vo.utils;/*
 *@program:MockSpace
 *@author: liangxm
 *@Time: 2023/4/21  14:48
 *@description: 物流调度Excel工具类
 */

import com.example.mockspace.common.FieldExport;
import com.yonyou.ocm.common.entity.FieldDisplay;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 梁晓明
 */
@Component
public class LogisticsExcelUtils {

    public <T>SXSSFWorkbook buildWorkbook(String sheetName, Class<T> cls, List<T> list, SXSSFWorkbook wb){
        Sheet sheet = wb.createSheet(sheetName);

        List<Field> exportFields = new ArrayList<>();
        Class<? super T> tempCls = cls;
        while (tempCls != null) {
            Field[] fields = tempCls.getDeclaredFields();
            for (Field field : fields) {
                boolean isExport = field.isAnnotationPresent(FieldDisplay.class);
                if (isExport) {
                    exportFields.add(field);
                }
            }
            // 获取父类
            tempCls = tempCls.getSuperclass();
        }
        CellStyle noteStyle = wb.createCellStyle();
        Font noteFont = wb.createFont();
        noteFont.setBold(true);
        noteFont.setColor(Font.COLOR_RED);
        noteStyle.setFont(noteFont);
        noteStyle.setAlignment(HorizontalAlignment.LEFT);
        noteStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        noteStyle.setWrapText(false);

        CellStyle headStyle = wb.createCellStyle();
        headStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = wb.createFont();
        font.setBold(true);
        headStyle.setFont(font);
        headStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setAlignment(HorizontalAlignment.LEFT);
        headStyle.setWrapText(false);
        // 创建标题行, 在sheet中添加表头第0行, 注意老版本poi对Excel的行数列数有限制
        Row attributeRow = sheet.createRow(0);
        Row nameRow = sheet.createRow(1);
        sheet.createFreezePane(0, 1);
        for (int idx = 0; idx < exportFields.size(); idx++) {
            Field exportField = exportFields.get(idx);
            FieldExport exportInfo = exportField.getAnnotation(FieldExport.class);

            Cell cell1 = attributeRow.createCell(idx);
            if ("no".equals(exportField.getName())){
                cell1.setCellValue("序号对应相同的数据");
                cell1.setCellStyle(noteStyle);
            }else{
                cell1.setCellValue(exportField.getName());
                cell1.setCellStyle(headStyle);
            }

            Cell cell = nameRow.createCell(idx);
            cell.setCellValue(exportInfo.name());
            cell.setCellStyle(headStyle);

            sheet.setColumnWidth(idx, exportInfo.width() * 256);
        }

        // 设置列宽

        if (list == null) {
            return wb;
        }

        // 设置日期单元格格式
        CellStyle dateStyle = wb.createCellStyle();
        short dateFormat = wb.createDataFormat().getFormat("yyyy-mm-dd");
        dateStyle.setDataFormat(dateFormat);

        // 更新单元格内容
        for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
            //获取到当前行的所有数据
            T dto = list.get(rowIdx);
            attributeRow = sheet.createRow(rowIdx + 2);
            for (int colIdx = 0; colIdx < exportFields.size(); colIdx++) {
                Field exportField = exportFields.get(colIdx);
                Object obj = getFieldValue(exportField, dto);
                Cell cell = attributeRow.createCell(colIdx);
                if (obj == null) {
                    cell.setCellValue("");
                }
                else if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                    cell.setCellStyle(dateStyle);
                }
                else if (obj instanceof Number) {
                    cell.setCellValue(new BigDecimal(obj.toString()).setScale(2, RoundingMode.HALF_UP).doubleValue());
                }
                else {
                    cell.setCellValue(obj.toString());
                }
            }
        }
        return wb;
    }

    private Object getFieldValue(Field field, Object obj) {
        Object fieldValue = null;
        String fieldName = field.getName();
        Class<?> cls = field.getDeclaringClass();
        try {
            // 通过get方法获取值
            Method getMethod = cls.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            fieldValue = getMethod.invoke(obj);
        }
        catch (ReflectiveOperationException ignore) {
            try {
                // 直接获取值
                fieldValue = field.get(obj);
            }
            catch (IllegalAccessException e) {
//                log.warn("获取导出字段失败: {}.{}", cls.getSimpleName(), fieldName);
            }
        }
        return fieldValue;
    }

}
