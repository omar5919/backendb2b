package com.incloud.tgestiona.framawork.blobstorage.impl;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import com.incloud.tgestiona.framawork.blobstorage.BlobstoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BlobstoreImpl implements BlobstoreService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${portal.store.sastoken}")
    private String sastoken;

    @Value("${portal.store.container}")
    private String container;

    @Value("${portal.store.endpoint}")
    private String endpoint;

    @Value("${portal.store.containerName}")
    private String containerName;

    /*
     * Create Containers
     * */
    @Override
    public BlobStoreFile createContainers(String folderId) {//, MultipartFile file

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint).sasToken(sastoken).buildClient();

        BlobContainerClient blobBlobContainer = blobServiceClient.createBlobContainer(folderId);
        if (!blobBlobContainer.exists())
            blobBlobContainer.create();

        BlobStoreFile blobStoreFile = new BlobStoreFile();

        blobStoreFile.setId(folderId);
        blobStoreFile.setName(folderId);
        blobStoreFile.setUrl(blobServiceClient.getAccountUrl());

        return blobStoreFile;
    }

    @Override
    public BlobStoreFile createBlobClient(String filName, MultipartFile file) throws IOException {

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint).sasToken(sastoken).buildClient();

        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        BlobClient blobClient = containerClient.getBlobClient(filName);
        if (blobClient.exists())
            blobClient.delete();

        blobClient.upload(file.getInputStream(), file.getSize(), true);

        //Setter properties blobClient Azure
        BlobStoreFile blobStoreFile = new BlobStoreFile();
        blobStoreFile.setType(blobClient.getBlockBlobClient().getProperties().getContentType());
        blobStoreFile.setUrl(blobClient.getBlockBlobClient().getBlobUrl());
        blobStoreFile.setName(blobClient.getBlockBlobClient().getBlobName());

        return blobStoreFile;
    }

    /*
     *getFile file for ID
     * */
    @Override
    public byte[] getFile(String archivoId) throws IOException {

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint).sasToken(sastoken).buildClient();
        BlobContainerClient blobClient = blobServiceClient.getBlobContainerClient(containerName);

        String uniqueFileName = getUniqueFileName(".");
        blobClient.getBlobClient(archivoId).downloadToFile(uniqueFileName, true);

        return Files.readAllBytes(new File(uniqueFileName).toPath());
    }

    /*
     *Delete file for ID
     * */
    @Override
    public void deleteFile(String archivoId) {

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint).sasToken(sastoken).buildClient();
        BlobContainerClient blobClient = blobServiceClient.getBlobContainerClient(containerName);
        BlobClient returnblobClient = blobClient.getBlobClient(archivoId);
        if (returnblobClient.exists())
            returnblobClient.delete();

    }


    @Override
    public List<BlobStoreFile> getListFileByFolderId() {

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint).sasToken(sastoken).buildClient();

        List<BlobStoreFile> list = new ArrayList<>();
        BlobContainerClient blobClient = blobServiceClient.getBlobContainerClient(containerName);
        blobClient.listBlobs().forEach(e -> {

            BlobClient blobClientDownload = blobClient.getBlobClient(e.getName());

            BlobStoreFile blobStoreFile = new BlobStoreFile();
            blobStoreFile.setName(blobClientDownload.getBlobName());
            blobStoreFile.setId(blobClientDownload.getSnapshotId());
            blobStoreFile.setUrl(blobClientDownload.getBlobUrl());
            blobStoreFile.setType(blobClientDownload.getProperties().getContentType());
            list.add(blobStoreFile);

        });


        return list;
    }

    private static String getUniqueFileName(String directory) {
        String fileName = MessageFormat.format("{0}", UUID.randomUUID());
        return Paths.get(directory, fileName).toString();
    }

}
