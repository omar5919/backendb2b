
package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;
import java.util.logging.Logger;


public class IdentifiableHashBuilder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object technicalId;

    public int hash(Logger log, Identifiable<?> identifiable) {
        if (technicalId == null) {
            if (identifiable.isIdSet()) {
                technicalId = identifiable.getId();
            } else {
                technicalId = new java.rmi.dgc.VMID();
                log.warning("DEVELOPER: hashCode is not safe." //
                        + "If you encounter this message you should take the time to carefuly " //
                        + "review the equals/hashCode methods for: " + identifiable.getClass().getCanonicalName() //
                        + " You may consider using a business key.");
            }
        }
        return technicalId.hashCode();
    }
}
