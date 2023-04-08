package model;


import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "eproduct")   
public class Product { 


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "date_added")
	private Date dateAdded;  
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productCategory_fk")
	private long categoryId;  
	

	public long getID() {return this.ID; }  
	public String getName() { return this.name;} 
	public BigDecimal getPrice() { return this.price;} 
	public long getCategoryId() { return this.categoryId;}
	public Date getDateAdded() { return this.dateAdded;}

	
	public void setID(long id) { this.ID = id;}
	public void setName(String value) { this.name = value;}
	public void setPrice(BigDecimal value) { this.price = value;}
	public void setCategoryId(long value) { this.categoryId = value;}
	public void setDateAdded(Date date) { this.dateAdded = date;}
}
