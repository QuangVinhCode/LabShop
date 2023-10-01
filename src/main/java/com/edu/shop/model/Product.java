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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
	@NamedQuery(name="searchByName",query="SELECT o FROM Product o WHERE o.name like ?1")
})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name must be entered")
	@Length(min = 5,message = "Length of name must be greater than 5 characters")
	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(nullable = false)
	@NotNull(message = "Price must be entered")
	@Min(value = 0,message = "Price must be greater than or equals 0")
	private Double price;
	
	@Column(length = 100)
	private String imageUrl;
	
	@Column(nullable = false)
	@Min(value = 0,message = "Quantily must be greater than or equals 0")
	@NotNull(message = "Quantily must be entered")
	private Integer quantily;
	
	@Column(nullable = false)
	@NotNull(message = "Discount must be entered")
	@Min(value = 0,message = "Discount must be greater than or equals 0")
	@Max(value = 100,message = "Discount must be greater than or equals 0")
	private Float discount;
	
	private ProductStatus status;
	
	@ManyToOne()
	@JoinColumn(name = "categoryId")
	Category category;
	
	@OneToMany(mappedBy = "product")
	Set<OrderDetail> orderDetails;
	
	@PrePersist
	public void prePersist()
	{
		createDate = new Date();
	}
}
