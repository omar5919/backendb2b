package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.service.dto.distritoDto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReportesRest extends JPACustomRest<Ofertas, Integer> {

    private static final String DATE_PATTERN = "yyyy/MM/dd";
    static String[] HEADERs = {"Id", "Title", "Description", "Published"};

    @GetMapping("/ofertas")
    public ResponseEntity<Resource> obtenerofertas(@RequestParam(required = false) Integer estado,
                                                   @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date desde,
                                                   @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date hasta)
    {

        Query query = entityManager.createNativeQuery("select * from oferta.sp_reporta_ofertas(?1,?2,?3);")
                .setParameter(1, new TypedParameterValue(StandardBasicTypes.INTEGER, estado))
                .setParameter(2, desde, TemporalType.TIMESTAMP)
                .setParameter(3, hasta, TemporalType.TIMESTAMP);
        List<Object[]> res = (List<Object[]>) query.getResultList();

        String filename = "oferta.xlsx";
        InputStreamResource file = null;
        try {
            Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Sheet sheet = workbook.createSheet("Oferta1");
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (int i = 0; i < res.size(); i++) {
                Row row = sheet.createRow(rowIdx++);
                for (int j = 0; j < res.get(i).length; j++) {
                    row.createCell(j).setCellValue(res.get(i)[j] != null ? res.get(i)[j].toString() : "");
                }
            }
            workbook.write(out);
            file = new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
            
        } catch (Exception e) {
            System.out.println("");
        }
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}
