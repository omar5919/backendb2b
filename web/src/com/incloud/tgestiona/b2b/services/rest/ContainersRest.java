package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Adjunto;
import com.incloud.tgestiona.b2b.servicesImpl.AdjuntoServiceImpl;
import com.incloud.tgestiona.framawork.blobstorage.impl.BlobStoreFile;
import com.incloud.tgestiona.framawork.blobstorage.impl.BlobstoreImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/Containers")
@CrossOrigin(origins = "http://localhost:4200")
public class ContainersRest extends com.incloud.tgestiona.util.MessagesUtils {

    private final Logger log = LoggerFactory.getLogger(ContainersRest.class);

    @Autowired
    private BlobstoreImpl blobstoreimpl;
    @Autowired
    private AdjuntoServiceImpl adjuntoServiceImpl;

    private boolean devuelveRuntimeException = true;

    //@Value("${user.b2b}")
    private String user;

    //@Value("${portal.store.containerName}")
    private String containerName;

    @ApiOperation(value = "Add file to Azure Container ", produces = "application/json")
    @PostMapping(value = "/uploadToContainers", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Adjunto> uploadToContainers(@RequestParam("file") MultipartFile file) throws IOException {

        HttpHeaders headers = new HttpHeaders();

        long leftLimit = 10L;
        long rightLimit = 1000000000000000000L;
        long generatedLong = new RandomDataGenerator().nextLong(leftLimit, rightLimit);
        //Setter name Original and Random Number
        String filenameGenerator = String.valueOf(generatedLong) + "-" + file.getOriginalFilename();

        BlobStoreFile blob = blobstoreimpl.createBlobClient(filenameGenerator, file);

        Adjunto adjunto = new Adjunto();
        adjunto.setArchivoId(String.valueOf(generatedLong));
        adjunto.setCarpetaId(containerName);
        adjunto.setArchivoNombre(blob.getName());
        adjunto.setRutaCatalogo(blob.getUrl());
        adjunto.setArchivoTipo(blob.getType());
        adjunto.setTipoAdjunto("1");
        adjunto.setEstado(1);
        adjunto.setAdjuntoUsuario(user);

        try {
            return Optional.ofNullable(adjuntoServiceImpl.save(adjunto)).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            if (this.devuelveRuntimeException) {
                String error = getMensageErrorExceptionDebug(e);
                throw new RuntimeException(error);
            }
            headers = this.returnErrorHeaders(e);
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Delete file to Azure Container ", produces = "application/json")
    @PostMapping(value = "/deleteFileContainers/{idFile}", produces = APPLICATION_JSON_VALUE)
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Adjunto> deleteFileContainers(@PathVariable("idFile") @Valid String id) throws Exception {

        HttpHeaders headers = new HttpHeaders();

        Adjunto adjunto = new Adjunto();
        adjunto.setArchivoId(id);

        Adjunto result = adjuntoServiceImpl.findEntity(adjunto);
        if (Optional.ofNullable(result).isPresent()) {
            System.out.println(result.getId());
            blobstoreimpl.deleteFile(result);
            //ACTUALIZAR A ESTADO BORRADO

            result.setEstado(2);

            adjuntoServiceImpl.save(result);
            log.info("Delete file from Azure ...Id " + result.getArchivoId());
        }

        try {
            return Optional.ofNullable(result).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            if (this.devuelveRuntimeException) {
                String error = getMensageErrorExceptionDebug(e);
                throw new RuntimeException(error);
            }
            headers = this.returnErrorHeaders(e);
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "List file(s) from Azure Container", produces = "application/json")
    @RequestMapping(value = "/listFilesContainers", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<Adjunto>> listFilesContainers() throws Exception {
        List<Adjunto> res = (List<Adjunto>) adjuntoServiceImpl.findAll();
        res.removeIf(p->p.getEstado() == 2);
        return Optional.of(new ResponseEntity<List<Adjunto>>(res, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Download file from Azure Container", produces = "application/json")
    @RequestMapping(value = "/downLoadFileContainers/{idFile}", method = RequestMethod.GET)
    public void downLoadFileContainers(@PathVariable("idFile") @Valid String id, HttpServletResponse response) throws IOException {

        Adjunto adjunto = new Adjunto();
        adjunto.setId(Integer.parseInt(id));
        Adjunto result = adjuntoServiceImpl.findEntity(adjunto);
        byte[] fileContent = blobstoreimpl.getFile(result.getArchivoNombre());
        log.info("Download file from Azure ...Id " + result.getArchivoId());
        try {
            response.setHeader("Pragma", "public");
            response.setHeader("Expires", "0");
            response.setHeader("Cache - Control", "must - revalidate, post - check = 0, pre - check = 0");
            response.setHeader("Content - type", "application - download");
            response.addHeader("Content-disposition", "attachment;filename=" + result.getArchivoNombre());
            response.setHeader("Content - Transfer - Encoding", "binary");
            OutputStream outStream = response.getOutputStream();
            outStream.write(fileContent);
            outStream.close();
            response.flushBuffer();
        } catch (Exception e) {
            throw new RuntimeException(getMensageErrorExceptionDebug(e));
        }
    }
}