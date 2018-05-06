package com.quoll.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Recurringorder implements Serializable {
    /**
     * primary key id
     */
    private Integer id;

    private Integer companyid;

    private String address;

    private Date pickupdate;

    private Date deliverdate;

    private Integer intervaldays;

    private Date enddate;

    /**
     * 0:inactive 1:active
     */
    private String active;

    @Transient
    private Company company;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getPickupdate() {
        return pickupdate;
    }

    public void setPickupdate(Date pickupdate) {
        this.pickupdate = pickupdate;
    }

    public Date getDeliverdate() {
        return deliverdate;
    }

    public void setDeliverdate(Date deliverdate) {
        this.deliverdate = deliverdate;
    }

    public Integer getIntervaldays() {
        return intervaldays;
    }

    public void setIntervaldays(Integer intervaldays) {
        this.intervaldays = intervaldays;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        Recurringorder other = (Recurringorder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPickupdate() == null ? other.getPickupdate() == null : this.getPickupdate().equals(other.getPickupdate()))
            && (this.getDeliverdate() == null ? other.getDeliverdate() == null : this.getDeliverdate().equals(other.getDeliverdate()))
            && (this.getIntervaldays() == null ? other.getIntervaldays() == null : this.getIntervaldays().equals(other.getIntervaldays()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
            && (this.getActive() == null ? other.getActive() == null : this.getActive().equals(other.getActive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPickupdate() == null) ? 0 : getPickupdate().hashCode());
        result = prime * result + ((getDeliverdate() == null) ? 0 : getDeliverdate().hashCode());
        result = prime * result + ((getIntervaldays() == null) ? 0 : getIntervaldays().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        result = prime * result + ((getActive() == null) ? 0 : getActive().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyid=").append(companyid);
        sb.append(", address=").append(address);
        sb.append(", pickupdate=").append(pickupdate);
        sb.append(", deliverdate=").append(deliverdate);
        sb.append(", intervaldays=").append(intervaldays);
        sb.append(", enddate=").append(enddate);
        sb.append(", active=").append(active);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}