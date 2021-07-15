package com.springboot.app.domain;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Imports")
public class Imports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long importId;

	@Column(name = "price")
	private Long price;

	@Column(name = "dateCreated")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Timestamp dateCreated;

	/*
	 * @Column(name = "userId") private Long userId;
	 */

	@OneToMany(mappedBy = "imports", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Import_Details> importDetails = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="supplierId")
	private Supplier supplier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private Users users;
	
	public Imports() {
		super();
	}
	
	public Long getImportId() {
		return importId;
	}

	public void setImportId(Long importId) {
		this.importId = importId;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	/*
	 * public Long getUserId() { return userId; }
	 * 
	 * public void setUserId(Long userId) { this.userId = userId; }
	 */

	public Set<Import_Details> getImportDetails() {
		return importDetails;
	}

	public void setImportDetails(Set<Import_Details> importDetails) {
		this.importDetails = importDetails;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Imports [importId=" + importId + ", price=" + price + ", dateCreated=" + dateCreated
				+ ", importDetails=" + importDetails + ", supplier=" + supplier + ", users=" + users + "]";
	}

	
	
	

	
}
