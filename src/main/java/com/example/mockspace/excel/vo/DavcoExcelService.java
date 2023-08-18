package com.example.mockspace.excel.vo;

import com.example.mockspace.common.FieldExport;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DavcoExcelService {
    public void downloadExcel(HttpServletResponse response, String fileName, Workbook workbook) {
        try (OutputStream outputStream = response.getOutputStream()) {
            // .xls格式
            if (workbook instanceof HSSFWorkbook) {
                if (!fileName.endsWith(".xls")){
                    fileName += ".xls";
                }
            }
            // .xlsx格式
            else if (workbook instanceof XSSFWorkbook || workbook instanceof SXSSFWorkbook) {
                if (!fileName.endsWith(".xlsx"))
                    fileName += ".xlsx";
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(outputStream);
            outputStream.flush();
        }
        catch (IOException e) {
            log.error("下载excel失败", e);
        }
    }

    /**
     * 通过FieldExport生成excel
     */
    public <T,K> Workbook buildWorkbook(String sheetName,String secondSheet, Class<T> cls, List<T> dtos,Class<K> cls2, List<K> dtos2) {
        // 创建一个Workbook, 对应一个Excel文件
        SXSSFWorkbook wb = new SXSSFWorkbook(new XSSFWorkbook(),-1);

        // 在workbook中添加一个sheet, 对应Excel文件中的sheet
        Sheet sheet = wb.createSheet(sheetName);

        // 获取导出字段
        List<Field> exportFields = new ArrayList<>();
        Class<? super T> tempCls = cls;
        while (tempCls != null) {
            Field[] fields = tempCls.getDeclaredFields();
            for (Field field : fields) {
                boolean isExport = field.isAnnotationPresent(FieldExport.class);
                if (isExport) {
                    exportFields.add(field);
                }
            }
            // 获取父类
            tempCls = tempCls.getSuperclass();
        }
        // 对字段排序
        exportFields = exportFields.stream().sorted((field1, field2) -> {
            FieldExport exportInfo1 = field1.getAnnotation(FieldExport.class);
            FieldExport exportInfo2 = field2.getAnnotation(FieldExport.class);
            return exportInfo1.sort() - exportInfo2.sort();
        }).collect(Collectors.toList());


        CellStyle noteStyle = wb.createCellStyle();
        Font notefont = wb.createFont();
        notefont.setBold(true);
        notefont.setColor(Font.COLOR_RED);
        noteStyle.setFont(notefont);
        noteStyle.setAlignment(HorizontalAlignment.LEFT);
        noteStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        noteStyle.setWrapText(false);

        // 设置表头格式
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
        Row row = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        // 冻结表头
        sheet.createFreezePane(0, 1);
        for (int idx = 0; idx < exportFields.size(); idx++) {
            Field exportField = exportFields.get(idx);
            FieldExport exportInfo = exportField.getAnnotation(FieldExport.class);

            Cell cell1 = row.createCell(idx);
            if ("no".equals(exportField.getName())){
                cell1.setCellValue("序号对应相同的数据");
                cell1.setCellStyle(noteStyle);
            }else{
                cell1.setCellValue(exportField.getName());
                cell1.setCellStyle(headStyle);
            }

            Cell cell = row1.createCell(idx);
            cell.setCellValue(exportInfo.name());
            cell.setCellStyle(headStyle);

            // 设置列宽
            sheet.setColumnWidth(idx, exportInfo.width() * 256);
        }

        if (dtos == null) {
            return wb;
        }

        // 设置日期单元格格式
        CellStyle dateStyle = wb.createCellStyle();
        short dateFormat = wb.createDataFormat().getFormat("yyyy-mm-dd");
        dateStyle.setDataFormat(dateFormat);

        // 更新单元格内容
        for (int rowIdx = 0; rowIdx < dtos.size(); rowIdx++) {
            //获取到当前行的所有数据
            T dto = dtos.get(rowIdx);
            row = sheet.createRow(rowIdx + 2);
            for (int colIdx = 0; colIdx < exportFields.size(); colIdx++) {
                Field exportField = exportFields.get(colIdx);
                Object obj = getFieldValue(exportField, dto);
                Cell cell = row.createCell(colIdx);
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

        Sheet sheet2 = wb.createSheet(secondSheet);

        // 获取导出字段
        List<Field> exportFields2 = new ArrayList<>();
        Class<? super K> tempCls2 = cls2;
        while (tempCls2 != null) {
            Field[] fields = tempCls2.getDeclaredFields();
            for (Field field : fields) {
                boolean isExport = field.isAnnotationPresent(FieldExport.class);
                if (isExport) {
                    exportFields2.add(field);
                }
            }
            // 获取父类
            tempCls2 = tempCls2.getSuperclass();
        }

        exportFields2 = exportFields2.stream().sorted((field1, field2) -> {
            FieldExport exportInfo1 = field1.getAnnotation(FieldExport.class);
            FieldExport exportInfo2 = field2.getAnnotation(FieldExport.class);
            return exportInfo1.sort() - exportInfo2.sort();
        }).collect(Collectors.toList());


        CellStyle noteStyle2 = wb.createCellStyle();
        Font notefont2 = wb.createFont();
        notefont2.setBold(true);
        notefont2.setColor(Font.COLOR_RED);
        noteStyle2.setFont(notefont2);
        noteStyle2.setAlignment(HorizontalAlignment.LEFT);
        noteStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
        noteStyle2.setWrapText(false);

        // 设置表头格式
        CellStyle headStyle2 = wb.createCellStyle();
        headStyle2.setAlignment(HorizontalAlignment.CENTER);
        Font font2 = wb.createFont();
        font2.setBold(true);
        headStyle2.setFont(font2);
        headStyle2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headStyle2.setBorderRight(BorderStyle.THIN);
        headStyle2.setBorderBottom(BorderStyle.THIN);
        headStyle2.setAlignment(HorizontalAlignment.LEFT);
        headStyle2.setWrapText(false);
        // 创建标题行, 在sheet中添加表头第0行, 注意老版本poi对Excel的行数列数有限制
        Row row2 = sheet2.createRow(0);
        Row row3 = sheet2.createRow(1);

        sheet2.createFreezePane(0, 1);


        for (int idx = 0; idx < exportFields2.size(); idx++) {
            Field exportField = exportFields2.get(idx);
            FieldExport exportInfo = exportField.getAnnotation(FieldExport.class);

            Cell cell1 = row2.createCell(idx);
            if ("no".equals(exportField.getName())){
                cell1.setCellValue("序号对应相同的数据");
                cell1.setCellStyle(noteStyle2);
            }else{
                cell1.setCellValue(exportField.getName());
                cell1.setCellStyle(headStyle2);
            }

            Cell cell = row3.createCell(idx);
            cell.setCellValue(exportInfo.name());
            cell.setCellStyle(headStyle2);

            // 设置列宽
            sheet2.setColumnWidth(idx, exportInfo.width() * 256);
        }

        if (dtos == null) {
            return wb;
        }

        // 设置日期单元格格式
        CellStyle dateStyle2 = wb.createCellStyle();
        short dateFormat2 = wb.createDataFormat().getFormat("yyyy-mm-dd");
        dateStyle2.setDataFormat(dateFormat2);

        // 更新单元格内容
        for (int rowIdx = 0; rowIdx < dtos2.size(); rowIdx++) {
            //获取到当前行的所有数据
            K dto = dtos2.get(rowIdx);
            row2 = sheet2.createRow(rowIdx + 2);
            for (int colIdx = 0; colIdx < exportFields2.size(); colIdx++) {
                Field exportField = exportFields2.get(colIdx);
                Object obj = getFieldValue(exportField, dto);
                Cell cell = row2.createCell(colIdx);
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
                log.warn("获取导出字段失败: {}.{}", cls.getSimpleName(), fieldName);
            }
        }
        return fieldValue;
    }
}
