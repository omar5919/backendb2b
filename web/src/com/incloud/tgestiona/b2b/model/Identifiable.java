
package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;

public interface Identifiable<PK extends Serializable> {

    String entityClassName();

    /**
     * @return the primary key
     */
    PK getId();

    /**
     * Sets the primary key
     *
     * @param id primary key
     */
    void setId(PK id);

    /**
     * Helper method to know whether the primary key is set or not.
     *
     * @return true if the primary key is set, false otherwise
     */
    boolean isIdSet();
}