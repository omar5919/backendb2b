package com.incloud.tgestiona.b2b.services.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import java.util.Optional;

import javax.validation.Valid;

import com.incloud.tgestiona.b2b.model.isis.IsisCliente;
import com.incloud.tgestiona.b2b.model.isis.IsisEquipo;
import com.incloud.tgestiona.b2b.model.isis.IsisTarifa;
import com.incloud.tgestiona.b2b.service.dto.EntityIsisInDto;
import com.incloud.tgestiona.b2b.service.dto.EntityIsisOutDto;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.incloud.tgestiona.b2b.repository.ClienteIsisRepository;
import com.incloud.tgestiona.b2b.repository.EquipoIsisRepository;
import com.incloud.tgestiona.b2b.repository.TarifaIsisRepository;
import com.incloud.tgestiona.framework.BindingErrorsResponse;
import com.incloud.tgestiona.framework.JPACustomRest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/IsisEntity")
//@CrossOrigin(origins = "http://localhost:4200")
public class IsisEntityRest{
    private T entity;

    private final Logger log = LoggerFactory.getLogger(IsisEquipo.class);

    @Autowired
    private ClienteIsisRepository _clienteRst;//IsisClienteRest
    @Autowired
    private TarifaIsisRepository _tarifaRst;//IsisTarifaRest
    @Autowired
    private EquipoIsisRepository _equipoRst;//IsisEquipoRest


    @ApiOperation(value = "Adjuntar archivo para ISIS-Generico", produces = "application/json")
    @PostMapping(value = "/uploadCVS", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityIsisOutDto> uploadCVS(@RequestBody @Valid EntityIsisInDto entityInputParam, BindingResult bindingResult) throws IOException {
        //BindingResult bindingResult = null;
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        EntityIsisOutDto entityOutDto = new EntityIsisOutDto();

        IsisCliente _cliente = null;
        IsisTarifa _tarifa = null;
        IsisEquipo _equipo = null;
        /**/
        if (entityInputParam.getUrl() == null) {
            headers.add("errors", "");
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        byte[] fileContent = IOUtils.toByteArray(new URL(entityInputParam.getUrl()));

        String row;
        long increment = 0;
        InputStream is = new ByteArrayInputStream(fileContent);
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));
        while ((row = csvReader.readLine()) != null) {

            String[] data = row.split(";");
            if (increment == 0) {
                increment++;
            } else {

                try {
                    if (entityInputParam.getEntity().equals("cliente")) {
                        _cliente = new IsisCliente();
                        _cliente = InsertInformacionCvs_clienteIsis(_cliente, data);
                        increment++;
                        entityOutDto.setTotalRecord(increment);
                    } else if (entityInputParam.getEntity().equals("tarifa")) {
                        _tarifa = new IsisTarifa();
                        _tarifa = InsertInformacionCvs_tarifaIsis(_tarifa, data);
                        increment++;
                        entityOutDto.setTotalRecord(increment);
                    } else if (entityInputParam.getEntity().equals("equipo")) {
                        _equipo = new IsisEquipo();
                        _equipo = InsertInformacionCvs_equipoIsis(_equipo, data);
                        increment++;
                        entityOutDto.setTotalRecord(increment);
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                } finally {
                    if (entityInputParam.getEntity().equals("cliente")) {
                        IsisCliente cl = _clienteRst.save(_cliente);
                    } else if (entityInputParam.getEntity().equals("tarifa")) {
                        IsisTarifa tr = _tarifaRst.save(_tarifa);
                    } else if (entityInputParam.getEntity().equals("equipo")) {
                        IsisEquipo eq = _equipoRst.save(_equipo);
                    }
                }
            }
        }

        csvReader.close();
        is.close();

        entityOutDto.setMsg("Record on table " + entityInputParam.getEntity().toString() + " and schema Isis is OK");
        log.info("Total of records on " + entityInputParam.getEntity().toString() + " Equipo and schema Isis %s", entityOutDto);

        try {
            return Optional.ofNullable(entityOutDto).map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            headers.add("errors", "");
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }


    private IsisCliente InsertInformacionCvs_clienteIsis(IsisCliente isiscliente, String[] data) {
        isiscliente.setClcodapli(data[1].trim());
        isiscliente.setClnomcli(data[1].trim());
        isiscliente.setClapecli(data[1].trim());
        isiscliente.setClcodcli(data[0].trim());
        isiscliente.setGctipdoc(data[4].trim());
        isiscliente.setGcrucgc(data[5].trim());
        isiscliente.setGctipgc(data[6].trim());
        isiscliente.setGccladat(data[7].trim());
        return isiscliente;
    }

    private IsisTarifa InsertInformacionCvs_tarifaIsis(IsisTarifa isistarifa, String[] data) {
        isistarifa.setCodTari(data[0].trim());
        isistarifa.setDesTari(data[1].trim());
        isistarifa.setMonto(data[2].trim());
        isistarifa.setMontoSolariza(data[3].trim());
        isistarifa.setTipPagoTari(data[4].trim());
        isistarifa.setFecInicTariVige(data[5].trim());
        isistarifa.setFecFinaTariVige(data[6].trim());
        isistarifa.setCodCon(data[7].trim());
        isistarifa.setDesConc(data[8].trim());
        isistarifa.setCodMone(data[9].trim());
        isistarifa.setCodGrupDsct(data[10].trim());
        isistarifa.setSec(data[11].trim());
        return isistarifa;
    }

    private IsisEquipo InsertInformacionCvs_equipoIsis(IsisEquipo isis_equipo, String[] data) {
        isis_equipo.setCodigoIsis(Integer.parseInt(data[0].trim()));
        isis_equipo.setB2bDedescripcion(data[1].trim());
        isis_equipo.setCodMarcEqui(Integer.parseInt(data[2].trim()));
        isis_equipo.setIndEqui(data[3].trim());
        isis_equipo.setMadesmar(data[4].trim());
        return isis_equipo;
    }


}

 
