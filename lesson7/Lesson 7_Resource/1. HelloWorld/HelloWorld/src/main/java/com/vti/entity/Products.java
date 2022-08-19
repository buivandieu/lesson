package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "`products`")
@NoArgsConstructor
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	@Column(name = "`product_code`", nullable = false, length = 60, unique = true)
	private String productCode;

	@Column(name = "`product_name`", nullable = false, length = 60)
	private String productName;

	@Column(name = "`product_desc`", nullable = false, length = 800)
	private String productDesc;

	@Column(name = "`product_img_name`", nullable = false, length = 200)
	private String productImgName;

	@Column(name = "`price`")
	private double price;
	
	@Column(name = "`total`")
	private int total;

	@Column(name = "`UNSIGNED`")
	private int UNSIGNED;
	
	@Column(name = "`TAX`")
	private int TAX;

	
}