package com.quoll.model;

import java.io.Serializable;

/**
 * @author 
 */
public class Orderitems extends OrderitemsKey implements Serializable {
    private Integer pickupnumber;

    private Integer packnumber;

    private static final long serialVersionUID = 1L;

    public Integer getPickupnumber() {
        return pickupnumber;
    }

    public void setPickupnumber(Integer pickupnumber) {
        this.pickupnumber = pickupnumber;
    }

    public Integer getPacknumber() {
        return packnumber;
    }

    public void setPacknumber(Integer packnumber) {
        this.packnumber = packnumber;
    }

    public Garment getGarment() {
        return garment;
    }

    public void setGarment(Garment garment) {
        this.garment = garment;
    }

    public Garment garment;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Orderitems other = (Orderitems) that;
        return (this.getGarmentid() == null ? other.getGarmentid() == null : this.getGarmentid().equals(other.getGarmentid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getPickupnumber() == null ? other.getPickupnumber() == null : this.getPickupnumber().equals(other.getPickupnumber()))
            && (this.getPacknumber() == null ? other.getPacknumber() == null : this.getPacknumber().equals(other.getPacknumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGarmentid() == null) ? 0 : getGarmentid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getPickupnumber() == null) ? 0 : getPickupnumber().hashCode());
        result = prime * result + ((getPacknumber() == null) ? 0 : getPacknumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pickupnumber=").append(pickupnumber);
        sb.append(", packnumber=").append(packnumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}