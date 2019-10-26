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
@Table(name = "tbCategory", schema = "dbo", catalog = "WebsiteBanLaptop")
public class CategoryEntity implements Serializable {

	private static final long serialVersionUID = 3906314052223358059L;
	
	private int categoryId;
	
    private String name;
    
    // Reference
 	private Set<LaptopEntity> laptops = new HashSet<LaptopEntity>(0);
 	
    public CategoryEntity() {
		super();
	}

	public CategoryEntity(int categoryId, String name, Integer parentid) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	@Id
    @Column(name = "categoryId")
	@TableGenerator(name="gen_id", table="HIBERNATE_GEN_ID", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public Set<LaptopEntity> getLaptops() {
		return laptops;
	}

	public void setLaptops(Set<LaptopEntity> laptops) {
		this.laptops = laptops;
	}
}
