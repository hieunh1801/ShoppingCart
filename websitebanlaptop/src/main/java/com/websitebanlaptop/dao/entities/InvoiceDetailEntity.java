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
@Table(name = "tbInvoiceDetail", schema = "dbo", catalog = "WebsiteBanLaptop")
public class InvoiceDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int invoiceDetailId;

	private int amonut;

	private float price;

	private LaptopEntity laptop;

	private InvoiceEntity invoice;
	

	public InvoiceDetailEntity() {
		super();
	}
	
	

	public InvoiceDetailEntity(int amonut, float price, LaptopEntity laptop, InvoiceEntity invoice) {
		super();
		this.amonut = amonut;
		this.price = price;
		this.laptop = laptop;
		this.invoice = invoice;
	}

	@Id
	@JoinColumn(name = "invoiceDetailId")
	@TableGenerator(name="gen_id", table="HIBERNATE_GEN_ID", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getInvoiceDetailId() {
		return invoiceDetailId;
	}

	public void setInvoiceDetailId(int invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}
	
	@ManyToOne
	@JoinColumn(name = "laptopid")
	public LaptopEntity getLaptop() {
		return this.laptop;
	}

	public void setLaptop(LaptopEntity laptop) {
		this.laptop = laptop;
	}

	@ManyToOne
	@JoinColumn(name = "invoiceid")
	public InvoiceEntity getInvoice() {
		return this.invoice;
	}

	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}
	
	@Column(name = "amount")
	public int getAmonut() {
		return amonut;
	}

	public void setAmonut(int amonut) {
		this.amonut = amonut;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
