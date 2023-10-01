package com.edu.shop.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Temporal(TemporalType.DATE)
	private Date orderedDate;
	
	@Column(columnDefinition = "nvarchar(200)")
	private String deccription;
	
	@Column(nullable = false)
	private OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;
	
	@OneToMany(mappedBy = "order")
	Set<OrderDetail> orderDetails;
}
