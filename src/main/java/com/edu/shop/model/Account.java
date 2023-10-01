package com.edu.shop.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Accounts", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	@Id
	@Column(length = 30)
	private String username;
	
	@Column(length = 20)
	private String password;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String fullname;
	
	@Column(columnDefinition = "nvarchar(100) not null")
	private String email;
	
	@Column(columnDefinition = "nvarchar(255) not null")
	private String photo;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	private AccountStatus status;
	
	private AccountRole role;
	
	@OneToMany(mappedBy = "account")
	private Set<Order> orders;
	
	@PrePersist
	public void preCreate() {
		createDate = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		createDate = new Date();
	}
}
