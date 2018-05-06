package com.quoll.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 
 */
public class GarmentList implements Serializable {
    private List<Garment> garments;

    public List<Garment> getGarments() {
        return garments;
    }

    public void setUsers(List<Garment> garments) {
        this.garments = garments;
    }
}