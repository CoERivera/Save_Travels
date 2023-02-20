package com.christopherrivera.savetravels.models;

import java.text.NumberFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="An expense name should be given.")
	@Size(min = 5, max = 100, message = "Expense name should be between 5 and 100 characters long.")
	private String expenseName;
	@NotNull(message="A vendor name should be given.")
	@Size(min = 5, max = 100, message = "Vendor name should be between 5 and 100 characters long.")
	private String vendorName;
	@NotNull(message="An amount should be given.")
	@Min(value=0, message="Cannot be a negative amount.")
	private double amount;
	@NotNull(message="A description should be given.")
	@Size(min = 3, max = 200, message = "Description should be between 3 and 200 characters long.")
	private String description;
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public Expense() {
	}
	
	public Expense(String expenseName, String vendorName, double amount, String description) {
		this.expenseName = expenseName;
		this.vendorName = vendorName;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public double getAmount() {
		return amount;
	}
	
	public String getFormattedAmount() {
		return NumberFormat.getCurrencyInstance().format(amount);
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
