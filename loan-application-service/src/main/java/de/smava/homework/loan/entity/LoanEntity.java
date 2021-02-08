package de.smava.homework.loan.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.smava.homework.loan.model.LoanStatus;

@Data
@Entity
@Table(name = "loan")
public class LoanEntity {
	@Id
    private String id;
	@Column(name = "customerId", updatable=false, insertable=false)
	private String customerId;
    private Double amount;
    private Integer duration;
	private LoanStatus status;
	
    @ManyToOne
    @JoinColumn(name = "customerId")    
    private CustomerEntity customer;
    
	public LoanEntity() {
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public LoanStatus getStatus() {
		return status;
	}
	public void setStatus(LoanStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoanEntity [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", duration=" + duration
				+ ", status=" + status + ", customer=" + customer + "]";
	}
    
}
