package com.incloud.tgestiona.framawork.blobstorage.impl;

public class BlobStoreFile {

    private String id;
    private String name;
    private String url;
    private String type;
    private BlobStoreFile parent;

    public BlobStoreFile() {
        this.parent = null;
    }

    public BlobStoreFile(String id, String name, String url, String type, BlobStoreFile parent) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.type = type;
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BlobStoreFile getParent() {
        return parent;
    }

    public void setParent(BlobStoreFile parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "BlobStoreFile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", parent=" + parent +
                '}';
    }
}
