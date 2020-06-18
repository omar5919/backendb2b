package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.service.dto.distritoDto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
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
    static String[] HEADERs = {
            "Codigo Oportunidad",
            "Fase",
            "Desc. Oportunidad",
            "Codigo Cliente",
            "RUC",
            "Razón Social",
            "Dirección",
            "Gerente de Cuenta",
            "Segmento Negocio",
            "Codigo Oferta",
            "Versión Oferta",
            "Caso Salesforce",
            "F.Ini",
            "F.Fin",
            "Preventa",
            "Estado Oferta",
            "F. Registrado",
            "F. Pres. Gerente Cuenta",
            "Dias Calendario PV",
            "F. Derivado AF",
            "F. Analista Financiero",
            "F. Devuelto a PV",
            "Dias Calendario AD",
            "Contacto Cliente",
            "Telefono",
            "Correo",
            "Descripción del Proyecto",
            "Observaciones",
            "Resultado",
            "Aprobadores",
            "TOTAL SEDES",
            "TOTAL SEDES LIMA",
            "TOTAL SEDES PROV",
            "TOTAL SERVICIOS",
            "TOTAL SISEGOS",
            "TOTAL ZONA VERDE",
            "TOTAL ZONA AMARILLA",
            "TOTAL ZONA GRIS",
            "Ultima Milla S/.",
            "Tx S/.",
            "P.E S/.",
            "Días Ejecución Max. SISEGO",
            "Router Total",
            "Router Stock",
            "Routers US$ Stock",
            "Router ,No Stock",
            "Routers US$ No Stock",
            "Router Residual",
            "Routers US$ Residual",
            "Router Log. Inversa",
            "Routers US$ Log. Inversa",
            "Router Renting",
            "Routers US$ Renting",
            "Routers Arrendador",
            "TODOS LOS EQUIPOS",
            "Gestion Proyectos S/.",
            "Asistente Proyectos S/.",
            "…",
            "Otros S/.",
            "Adjuntos OTE",
            "Adjuntos Cotizaciones",
            "Adjuntos Otros",
            "Fecha Registrado",
            "Fecha Evaluado",
            "Cantidad Derivadas",
            "Fecha Derivado a AF",
            "Fecha Analisis Financiero",
            "Fecha Finanzas(Aprobado)",
            "Fecha Finanzas(Rechazado)",
            "Motivo",
            "Fecha Presenta Gerente Cuenta",
            "Fecha Ganado",
            "Anulado",
            "INGRESO ANUAL  (s/.)",
            "COSTO DIRECTO ANUAL  (s/.)",
            "OIBDA ANUAL (s/.)",
            "CAPEX A SOLICITAR (s/.)",
            "CAPEX NO SOLICITADO (s/.)",
            "ARRENDAMIENTO OPERATIVO (S/.)",
            "VAN PROYECTO (s/.)",
            "VAN/VAI PROYECTO",
            "MARGEN COMERCIAL ( % )",
            "PAYBACK PROYECTO (Meses)",
            "TIPO DE CAMBIO",
            "CAPEX /INGRESO",
            "FCV CON IGV (s/.)",
            "CLEAR CHANNEL N.S.",
            "DIGIRED",
            "INFOINTERNET",
            "IP ADSL",
            "INTERNET@S",
            "IP VPN ETHERNET",
            "IP VPN",
            "IP VPN INTERNACIONAL",
            "IP VPN SATELITAL",
            "SEGURIDAD GESTIONADA",
            "UNIRED",
            "VSAT"
    };

    @Autowired
    private OfertasRepository iRepo;

    @GetMapping("/ofertas")
    public ResponseEntity<Resource> obtenerofertas(@RequestParam(required = false) Integer estado,
                                                   @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date desde,
                                                   @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date hasta) {

        Query query = entityManager.createNativeQuery("select * from oferta.sp_reporte_ofertas(?1,?2,?3);")
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
                CellStyle cs = workbook.createCellStyle();
                cs.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                Font f = workbook.createFont();
                f.setBold(true);
                cs.setFont(f);
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
                cell.setCellStyle(cs);
            }
            int rowIdx = 1;
            for (Object[] re : res) {
                Row row = sheet.createRow(rowIdx++);
                for (int j = 0; j < re.length; j++) {
                    row.createCell(j).setCellValue(re[j] != null ? re[j].toString() : "");
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


    @GetMapping("/plantillaImplantacion")
    public ResponseEntity<Resource> plantillaImplantacion(@RequestParam(required = false) Integer ofertaId) {

        List<Object[]> res = (List<Object[]>) iRepo.plantillaImpantacion(ofertaId);

        String filename = "plantillaImpantacion.xlsx";
        InputStreamResource file = null;
        try {
            Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Sheet sheet = workbook.createSheet("plantillaImpantacion");
            //int rowIdx = 0;
            for (int i = 0; i < res.size(); i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < res.get(i).length; j++) {
                    if (i == 0) {
                        row.createCell(j).setCellValue(res.get(i)[j] != null ? (j == 0 ? "N°" : res.get(i)[j].toString()) : "");
                    } else {
                        row.createCell(j).setCellValue(res.get(i)[j] != null ? res.get(i)[j].toString() : "");
                    }
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
