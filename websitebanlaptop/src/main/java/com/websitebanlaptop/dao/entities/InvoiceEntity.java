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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbInvoice", schema = "dbo", catalog = "WebsiteBanLaptop")
public class InvoiceEntity implements Serializable {

	private static final long serialVersionUID = 2122402088522630641L;

	private int invoiceId;
	private int employeeId;
	private Timestamp createdDate;
	private String notes;

	private SupplierEntity supplier;
	// Reference
	private Set<InvoiceDetailEntity> invoiceDetails = new HashSet<InvoiceDetailEntity>(0);

	public InvoiceEntity(int employeeId, Timestamp createdDate, String notes) {
		super();
		this.employeeId = employeeId;
		this.createdDate = createdDate;
		this.notes = notes;
	}

	
	public InvoiceEntity(int employeeId, Timestamp createdDate, String notes, SupplierEntity supplier) {
		super();
		this.employeeId = employeeId;
		this.createdDate = createdDate;
		this.notes = notes;
		this.supplier = supplier;
	}


	public InvoiceEntity() {
		super();
	}

	@Column(name = "invoiceid")
	@Id
	@TableGenerator(name="gen_id", table="HIBERNATE_GEN_ID", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "employeeid")
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "createdate")
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<InvoiceDetailEntity> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(Set<InvoiceDetailEntity> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	@ManyToOne
	@JoinColumn(name = "supplierid", nullable = false)
	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

}
