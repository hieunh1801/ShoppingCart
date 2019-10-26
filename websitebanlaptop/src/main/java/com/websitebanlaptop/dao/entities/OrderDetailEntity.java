package com.websitebanlaptop.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbOrderDetail", schema = "dbo", catalog = "WebsiteBanLaptop")
public class OrderDetailEntity implements Serializable {

	private static final long serialVersionUID = -944527494427389178L;	
	private int orderDetailId;
    private Double totalprice;
    private Integer quantity;
    private LaptopEntity laptop;	
    private OrderEntity order;
    
    public OrderDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

    public OrderDetailEntity(Double totalprice, Integer quantity, LaptopEntity laptop, OrderEntity order) {
		super();
		this.totalprice = totalprice;
		this.quantity = quantity;
		this.laptop = laptop;
		this.order = order;
	}
    
    

	public OrderDetailEntity(Double totalprice, Integer quantity, LaptopEntity laptop) {
		super();
		this.totalprice = totalprice;
		this.quantity = quantity;
		this.laptop = laptop;
	}

	@Id
    @JoinColumn(name = "orderDetailId")
    @TableGenerator(name="gen_id", table="HIBERNATE_GEN_ID", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
    
	@ManyToOne
    @JoinColumn(name = "orderid")
    public OrderEntity getOrder() {
    	return this.order;
    }
    
    public void setOrder(OrderEntity order) {
    	this.order = order;
    }
    

    @ManyToOne
    @JoinColumn(name = "laptopid")
    public LaptopEntity getLaptop() {
    	return this.laptop;
    }
    
    public void setLaptop(LaptopEntity laptop) {
    	this.laptop = laptop;
    }
    
    @Column(name = "totalprice")
    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((laptop == null) ? 0 : laptop.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((totalprice == null) ? 0 : totalprice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailEntity other = (OrderDetailEntity) obj;
		if (laptop == null) {
			if (other.laptop != null)
				return false;
		} else if (!laptop.equals(other.laptop))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (totalprice == null) {
			if (other.totalprice != null)
				return false;
		} else if (!totalprice.equals(other.totalprice))
			return false;
		return true;
	}
}
