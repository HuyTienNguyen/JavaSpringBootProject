package com.springboot.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Import_Details")
public class Import_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long importDetailId;
	@Column(name = "productId")
	private Long productId;
	@Column(name = "unit")
	private String unit;
	@Column(name = "price")
	private Long price;
	@Column(name = "quantity")
	private Long quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="importId")
	private Imports imports;
	public Import_Details() {
		super();
	}
	public Long getImportDetailId() {
		return importDetailId;
	}
	public void setImportDetailId(Long importDetailId) {
		this.importDetailId = importDetailId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Imports getImports() {
		return imports;
	}
	public void setImports(Imports imports) {
		this.imports = imports;
	}
	
	
	@Override
	public String toString() {
		return "Import_Details [importDetailId=" + importDetailId + ", productId=" + productId + ", unit=" + unit
				+ ", price=" + price + ", quantity=" + quantity + ", imports=" + imports + "]";
	}
	
	
}
