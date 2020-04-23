package com.incloud.tgestiona.framework;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class LazyLoadEvent {

    /**
     * First row offset.
     */
    public int page;

    /**
     * Number of rows per page.
     */
    public int size;

    public String sortField;
    public int sortOrder = 1;



    public Pageable toPageable() {
        if (sortField != null) {
            return PageRequest.of(page - 1 , size, toSortDirection(), sortField);
        } else {
            return PageRequest.of(page - 1, size);
        }
    }


    public Pageable toPageable(Sort sortAvanzado) {
        return PageRequest.of(toPageIndex(), size, sortAvanzado);

    }

    /**
     * Zero based page index.
     */
    public int toPageIndex() {
        return (page + size) / size - 1;
    }

    public Sort.Direction toSortDirection() {
        return sortOrder == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
    }

}