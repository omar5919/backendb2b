package com.incloud.tgestiona.framawork.blobstorage;

import com.azure.storage.blob.BlobContainerClient;
import com.incloud.tgestiona.b2b.model.Adjunto;
import com.incloud.tgestiona.framawork.blobstorage.impl.BlobStoreFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlobstoreService {

    public BlobStoreFile createContainers(String folderId);

    public BlobStoreFile createBlobClient(String filName, MultipartFile file) throws IOException;

    public byte[] getFile(String archivoId) throws IOException;

    public void deleteFile(Adjunto archivo);

    public List<BlobStoreFile> getListFileByFolderId();

}
