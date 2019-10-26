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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbLaptop", schema = "dbo", catalog = "WebsiteBanLaptop")
public class LaptopEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8424005848913830208L;
	private int laptopId;
	private String name;
	private String title;
	private String description;
	private Integer quantity;
	private String size;
	private String weight;
	private String height;
	private String color;
	private String image;
	private String memory;
	private String os;
	private String ram;
	private String cpu;
	private String battery;
	private int status;
	private CategoryEntity category;
	private Float price;

	// Reference
	private Set<ArticleEntity> articles = new HashSet<ArticleEntity>(0);
	private Set<PromotionEntity> promotions = new HashSet<PromotionEntity>(0);
	private Set<OrderDetailEntity> orderDetails = new HashSet<OrderDetailEntity>(0);
	private Set<InvoiceDetailEntity> invoiceDetails = new HashSet<InvoiceDetailEntity>(0);

	public LaptopEntity() {
		super();
	}

	public LaptopEntity(String name, String title, String description, String size, String weight, String height,
			String color, String image, String memory, String os, String ram, String cpu, String battery,
			CategoryEntity category, int status) {
		super();
		this.name = name;
		this.title = title;
		this.description = description;
		this.size = size;
		this.weight = weight;
		this.height = height;
		this.color = color;
		this.image = image;
		this.memory = memory;
		this.os = os;
		this.ram = ram;
		this.cpu = cpu;
		this.battery = battery;
		this.category = category;
		this.status = status;
	}

	public LaptopEntity(int laptopId, String name, String title, String description, Integer quantity, String size,
			String weight, String height, String color, String image, String memory, String os, String ram, String cpu,
			String battery, CategoryEntity category, int status) {
		super();
		this.laptopId = laptopId;
		this.name = name;
		this.title = title;
		this.description = description;
		this.quantity = quantity;
		this.size = size;
		this.weight = weight;
		this.height = height;
		this.color = color;
		this.image = image;
		this.memory = memory;
		this.os = os;
		this.ram = ram;
		this.cpu = cpu;
		this.battery = battery;
		this.category = category;
		this.status = status;
	}

	
	public LaptopEntity(int laptopId, String name, String title, String description, Integer quantity, String size,
			String weight, String height, String color, String image, String memory, String os, String ram, String cpu,
			String battery, int status, CategoryEntity category, Float price) {
		super();
		this.laptopId = laptopId;
		this.name = name;
		this.title = title;
		this.description = description;
		this.quantity = quantity;
		this.size = size;
		this.weight = weight;
		this.height = height;
		this.color = color;
		this.image = image;
		this.memory = memory;
		this.os = os;
		this.ram = ram;
		this.cpu = cpu;
		this.battery = battery;
		this.status = status;
		this.category = category;
		this.price = price;
	}

	@Id
	@Column(name = "laptopId")
	@TableGenerator(name = "gen_id", table = "HIBERNATE_GEN_ID", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "weight")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(name = "height")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "memory")
	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	@Column(name = "os")
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Column(name = "ram")
	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Column(name = "cpu")
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Column(name = "battery")
	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laptop", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<ArticleEntity> getArticles() {
		return articles;
	}

	public void setArticles(Set<ArticleEntity> articles) {
		this.articles = articles;
	}

	@ManyToOne
	@JoinColumn(name = "categoryid", nullable = false)
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laptop", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laptop", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<PromotionEntity> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<PromotionEntity> promotions) {
		this.promotions = promotions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laptop", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<InvoiceDetailEntity> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(Set<InvoiceDetailEntity> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "price")
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
