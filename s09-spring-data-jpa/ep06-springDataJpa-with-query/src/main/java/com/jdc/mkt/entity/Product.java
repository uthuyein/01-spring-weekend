package com.jdc.mkt.entity;

import java.util.List;

import com.jdc.mkt.entity.enumeration.Size;
import com.jdc.mkt.listener.EnableTimeListener;
import com.jdc.mkt.listener.TimeListener;
import com.jdc.mkt.listener.Times;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_tbl")
@EntityListeners(TimeListener.class)

@NamedNativeQuery(
		name = "Product.selectAllProduct",
		resultClass = Product.class,
		query = "select * from product_tbl")

@NamedQueries({
@NamedQuery(
		name = "Product.findProductByNam",
		query = "select p from Product p where p.name = ?1"
		),

@NamedQuery(
		name = "Product.findProductByDetail",
		query = "select p from Product p where p.detailPrice between :frm and :to"
		)
})
public class Product implements EnableTimeListener{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	private Integer detailPrice;
	private Integer wholeSalePrice;
	private Times times;
	
	@ElementCollection
	@Column(name = "size")	
	@CollectionTable(name = "sizes_tbl"
	,joinColumns = @JoinColumn(name = "product_id"))
	private List<Size> sizes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	private Boolean isActive = true;
	
	
	
	

	public Product(String name, Integer detailPrice, Integer wholeSalePrice, List<Size> sizes, Category category) {
		this.name = name;
		this.detailPrice = detailPrice;
		this.wholeSalePrice = wholeSalePrice;
		this.sizes = sizes;
		this.category = category;
	}

	public Product(Integer id) {
		super();
		this.id = id;
	}
	
	
}
