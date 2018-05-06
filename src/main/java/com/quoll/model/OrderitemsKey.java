package com.quoll.model;

import java.io.Serializable;

/**
 * @author 
 */
public class OrderitemsKey implements Serializable {
    private Integer garmentid;

    private Integer orderid;

    private static final long serialVersionUID = 1L;

    public Integer getGarmentid() {
        return garmentid;
    }

    public void setGarmentid(Integer garmentid) {
        this.garmentid = garmentid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

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
        OrderitemsKey other = (OrderitemsKey) that;
        return (this.getGarmentid() == null ? other.getGarmentid() == null : this.getGarmentid().equals(other.getGarmentid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGarmentid() == null) ? 0 : getGarmentid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", garmentid=").append(garmentid);
        sb.append(", orderid=").append(orderid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}