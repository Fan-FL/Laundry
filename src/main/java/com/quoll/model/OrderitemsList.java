package com.quoll.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 
 */
public class OrderitemsList implements Serializable {
    private List<Orderitems> items;

    public List<Orderitems> getOrderitems() {
        return items;
    }

    public void setUsers(List<Orderitems> garments) {
        this.items = garments;
    }
}