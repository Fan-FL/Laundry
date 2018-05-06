package com.quoll.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Laundryorder implements Serializable {
    /**
     * primary key id
     */
    private Integer id;

    /**
     * created time
     */
    private Date createddate;

    private String address;

    private Integer companyid;

    /**
     * prset pick up date
     */
    private Date presetpickupdate;

    /**
     * real pick up date
     */
    private Date realpickupdate;

    /**
     * packing date by packing person
     */
    private Date packingdate;

    private Date presetdeliverydate;

    /**
     * delivery date to custmer
     */
    private Date deliverydate;

    /**
     * 0:order created 1:picked up 2:partily packed 3:packed 4:delivered
     */
    private Integer status;

    /**
     * pickup driver
     */
    private Integer driverid;

    /**
     * packingperson be responsible for
     */
    private Integer packingpersonid;

    private String notes;

    private String statushistory;

    /**
     * delivery driver
     */
    private Integer deliverydriverid;

    /**
     * 0: none 1:recurring
     */
    private Integer recurringflag;
    
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Transient
    private Company company;

    @Transient
    private Integer statusLittleEnd;

    @Transient
    private Integer statusBiggerEnd;

    public Integer getStatusLittleEnd() {
        return statusLittleEnd;
    }

    public void setStatusLittleEnd(Integer statusLittleEnd) {
        this.statusLittleEnd = statusLittleEnd;
    }

    public Integer getStatusBiggerEnd() {
        return statusBiggerEnd;
    }

    public void setStatusBiggerEnd(Integer statusBiggerEnd) {
        this.statusBiggerEnd = statusBiggerEnd;
    }
    
    public User getPickupDriver() {
        return pickupDriver;
    }

    public void setPickupDriver(User pickupDriver) {
        this.pickupDriver = pickupDriver;
    }

    public User getDeliveryDriver() {
        return deliveryDriver;
    }

    public void setDeliveryDriver(User deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }

    public User getPackingPerson() {
        return packingPerson;
    }

    public void setPackingPerson(User packingPerson) {
        this.packingPerson = packingPerson;
    }

    @Transient
    private User pickupDriver;

    @Transient
    private User deliveryDriver;

    @Transient
    private User packingPerson;

    @Transient
    private String itemsDescription;

    @Transient
    private List<Orderitems> orderitemsList;

    public List<Orderitems> getOrderitemsList() {
        return orderitemsList;
    }

    public void setOrderitemsList(List<Orderitems> orderitemsList) {
        this.orderitemsList = orderitemsList;
    }

    public String getItemsDescription() {
        return itemsDescription;
    }

    public void setItemsDescription(String itemsDescription) {
        this.itemsDescription = itemsDescription;
    }
	

	/**
     * 0:inactive 1:active
     */
    private String active;
	
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Date getPresetpickupdate() {
        return presetpickupdate;
    }

    public void setPresetpickupdate(Date presetpickupdate) {
        this.presetpickupdate = presetpickupdate;
    }

    public Date getRealpickupdate() {
        return realpickupdate;
    }

    public void setRealpickupdate(Date realpickupdate) {
        this.realpickupdate = realpickupdate;
    }

    public Date getPackingdate() {
        return packingdate;
    }

    public void setPackingdate(Date packingdate) {
        this.packingdate = packingdate;
    }

    public Date getPresetdeliverydate() {
        return presetdeliverydate;
    }

    public void setPresetdeliverydate(Date presetdeliverydate) {
        this.presetdeliverydate = presetdeliverydate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDriverid() {
        return driverid;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    public Integer getPackingpersonid() {
        return packingpersonid;
    }

    public void setPackingpersonid(Integer packingpersonid) {
        this.packingpersonid = packingpersonid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatushistory() {
        return statushistory;
    }

    public void setStatushistory(String statushistory) {
        this.statushistory = statushistory;
    }

    public Integer getDeliverydriverid() {
        return deliverydriverid;
    }

    public void setDeliverydriverid(Integer deliverydriverid) {
        this.deliverydriverid = deliverydriverid;
    }

    public Integer getRecurringflag() {
        return recurringflag;
    }

    public void setRecurringflag(Integer recurringflag) {
        this.recurringflag = recurringflag;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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
        Laundryorder other = (Laundryorder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateddate() == null ? other.getCreateddate() == null : this.getCreateddate().equals(other.getCreateddate()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getPresetpickupdate() == null ? other.getPresetpickupdate() == null : this.getPresetpickupdate().equals(other.getPresetpickupdate()))
            && (this.getRealpickupdate() == null ? other.getRealpickupdate() == null : this.getRealpickupdate().equals(other.getRealpickupdate()))
            && (this.getPackingdate() == null ? other.getPackingdate() == null : this.getPackingdate().equals(other.getPackingdate()))
            && (this.getPresetdeliverydate() == null ? other.getPresetdeliverydate() == null : this.getPresetdeliverydate().equals(other.getPresetdeliverydate()))
            && (this.getDeliverydate() == null ? other.getDeliverydate() == null : this.getDeliverydate().equals(other.getDeliverydate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDriverid() == null ? other.getDriverid() == null : this.getDriverid().equals(other.getDriverid()))
            && (this.getPackingpersonid() == null ? other.getPackingpersonid() == null : this.getPackingpersonid().equals(other.getPackingpersonid()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
            && (this.getStatushistory() == null ? other.getStatushistory() == null : this.getStatushistory().equals(other.getStatushistory()))
            && (this.getDeliverydriverid() == null ? other.getDeliverydriverid() == null : this.getDeliverydriverid().equals(other.getDeliverydriverid()))
            && (this.getRecurringflag() == null ? other.getRecurringflag() == null : this.getRecurringflag().equals(other.getRecurringflag()))
            && (this.getActive() == null ? other.getActive() == null : this.getActive().equals(other.getActive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateddate() == null) ? 0 : getCreateddate().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getPresetpickupdate() == null) ? 0 : getPresetpickupdate().hashCode());
        result = prime * result + ((getRealpickupdate() == null) ? 0 : getRealpickupdate().hashCode());
        result = prime * result + ((getPackingdate() == null) ? 0 : getPackingdate().hashCode());
        result = prime * result + ((getPresetdeliverydate() == null) ? 0 : getPresetdeliverydate().hashCode());
        result = prime * result + ((getDeliverydate() == null) ? 0 : getDeliverydate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDriverid() == null) ? 0 : getDriverid().hashCode());
        result = prime * result + ((getPackingpersonid() == null) ? 0 : getPackingpersonid().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        result = prime * result + ((getStatushistory() == null) ? 0 : getStatushistory().hashCode());
        result = prime * result + ((getDeliverydriverid() == null) ? 0 : getDeliverydriverid().hashCode());
        result = prime * result + ((getRecurringflag() == null) ? 0 : getRecurringflag().hashCode());
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
        sb.append(", createddate=").append(createddate);
        sb.append(", address=").append(address);
        sb.append(", companyid=").append(companyid);
        sb.append(", presetpickupdate=").append(presetpickupdate);
        sb.append(", realpickupdate=").append(realpickupdate);
        sb.append(", packingdate=").append(packingdate);
        sb.append(", presetdeliverydate=").append(presetdeliverydate);
        sb.append(", deliverydate=").append(deliverydate);
        sb.append(", status=").append(status);
        sb.append(", driverid=").append(driverid);
        sb.append(", packingpersonid=").append(packingpersonid);
        sb.append(", notes=").append(notes);
        sb.append(", statushistory=").append(statushistory);
        sb.append(", deliverydriverid=").append(deliverydriverid);
        sb.append(", recurringflag=").append(recurringflag);
        sb.append(", active=").append(active);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}