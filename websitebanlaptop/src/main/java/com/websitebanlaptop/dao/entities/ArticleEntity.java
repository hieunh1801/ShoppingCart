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
@Table(name = "tbArticle", schema = "dbo", catalog = "WebsiteBanLaptop")
public class ArticleEntity implements Serializable {

	private static final long serialVersionUID = -2678537892753453196L;

	private int articleId;
	private String title;
	private String content;
	private String thumbnail;

	private LaptopEntity laptop;

	public ArticleEntity() {
		super();
	}

	public ArticleEntity(int articleId, String title, String content, String thumbnail) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.thumbnail = thumbnail;
	}

	@Id
	@Column(name = "articleId")
	@TableGenerator(name = "gen_id", table = "HIBERNATE_GEN_ID", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "thumbnail")
	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@ManyToOne
	@JoinColumn(name = "laptopid", nullable = false)
	public LaptopEntity getLaptop() {
		return laptop;
	}

	public void setLaptop(LaptopEntity laptop) {
		this.laptop = laptop;
	}
}
