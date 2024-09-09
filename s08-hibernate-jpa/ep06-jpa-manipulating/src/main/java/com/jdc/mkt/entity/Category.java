package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "category_tbl")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	@Column(nullable = false,length = 45)
	private String name;
	@Column(columnDefinition = "boolean not null default true")
	private Boolean isActive = true;
	
//  collection type should be one-to-many or many-to-many
	@OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST,orphanRemoval = true)
//	@JoinColumn(name = "cat_id")
	private List<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product p) {
		p.setCategory(this);
		this.products.add(p);
	}
}
