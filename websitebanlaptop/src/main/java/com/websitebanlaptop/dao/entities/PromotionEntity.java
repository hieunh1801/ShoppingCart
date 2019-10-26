package com.websitebanlaptop.dao.entities;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "tbPromotion", schema = "dbo", catalog = "WebsiteBanLaptop")
public class PromotionEntity implements Serializable {

	private static final long serialVersionUID = -9078309016473184040L;
	private int promotionId;
	private String value;
	private Double discount;
	private Timestamp startDate;
	private Timestamp endDate;
	private LaptopEntity laptop;
	
	public PromotionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromotionEntity(String value, Double discount, Timestamp startDate, Timestamp endDate, LaptopEntity laptop) {
		super();
		this.value = value;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.laptop = laptop;
	}

	@Id
	@Column(name = "promotionId")
	@TableGenerator(name="gen_id", table="HIBERNATE_GEN_ID", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	@Column(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "discount")
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "enddate")
	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp enddate) {
		this.endDate = enddate;
	}

	@ManyToOne
	@JoinColumn(name = "laptopid")
	public LaptopEntity getLaptop() {
		return laptop;
	}

	public void setLaptop(LaptopEntity laptop) {
		this.laptop = laptop;
	}

	@Column(name = "startdate")
	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
}
