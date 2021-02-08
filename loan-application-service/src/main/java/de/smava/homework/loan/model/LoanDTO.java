package de.smava.homework.loan.model;


import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class LoanDTO {
    private String id;
    @NotNull
    private Double amount;
    @NotNull
    private Integer duration;
    private String customerId;
    private LoanStatus status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public LoanStatus getStatus() {
		return status;
	}
	public void setStatus(LoanStatus status) {
		this.status = status;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public LoanDTO() {

	}
    
    
}
