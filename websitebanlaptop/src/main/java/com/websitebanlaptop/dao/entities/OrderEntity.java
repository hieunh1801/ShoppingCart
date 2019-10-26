package com.websitebanlaptop.dao.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbOrder", schema = "dbo", catalog = "WebsiteBanLaptop")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1733084642867952058L;
	
	private int orderId;
    
	private Boolean status;
    
	private Timestamp createDate;
    
    private Double totalPrice;
    
    private String note;
    
    private int customerId;

    // Reference
    private Set<OrderDetailEntity> orderDetails = new HashSet<OrderDetailEntity>(0);
    
    public OrderEntity() {
		super();
	}

	public OrderEntity(Boolean status, Timestamp createDate, Double totalPrice, String note,
			int customerId) {
		super();
		this.status = status;
		this.createDate = createDate;
		this.totalPrice = totalPrice;
		this.note = note;
		this.customerId = customerId;
	}

	@Id
    @Column(name = "orderId")
    @TableGenerator(name="gen_id", table="HIBERNATE_GEN_ID", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    @Column(name = "createdate")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    
    @Column(name = "totalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "customerid")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
