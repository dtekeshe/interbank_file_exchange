package com.bsva.entities.v02.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * File delivered by the Delivery Service
 *
 *
 */
@Entity
public class DeliveredFile implements Serializable {

    @Id
    @Column(name = "FILENAME")
    // TODO fix ORM name resolution warning
    private String filename;


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
