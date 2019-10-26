package com.websitebanlaptop.dao.entities;

import java.io.Serializable;
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
@Table(name = "tbSupplier", schema = "dbo", catalog = "WebsiteBanLaptop")
public class SupplierEntity implements Serializable {

	private static final long serialVersionUID = -1029148905343108066L;
	
	private int supplierId;
	private String name;
	private String phone;
	private String address;
	private String image;
	
	// Reference
    private Set<InvoiceEntity> invoices = new HashSet<InvoiceEntity>(0);
	
	public SupplierEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SupplierEntity(int supplierId, String name, String phone, String address) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}


	@Column(name = "supplierid")
	@Id
	@TableGenerator(name="gen_id", table="HIBERNATE_GEN_ID", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<InvoiceEntity> getInvoices() {
		return invoices;
	}


	public void setInvoices(Set<InvoiceEntity> invoices) {
		this.invoices = invoices;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
