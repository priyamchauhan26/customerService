package com.customersService.customersService.model;
import java.awt.Image;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="product_name")
	private String productname;
	@Column(name="price")
	private String price;
	@Column(name="total_quantity")
	private String totalquantity;
	@Column(name="sell_quantity")
	private String sellquantity;
	@Column(name="serial_Number")
	private  String serialnummber;
	@Column(name="brand_name")
	private String brandname;
	@Column(name="prod_Adress")
	private String address;
	@Column(name="prod_code")
	private String code;
	@Column(name="mid")
	private String mid;
	private String subcategory;
	private Long pcid;
	private String filename;
	@Column(name="prod_image")
	private String image;
	@Column(name="created_date")
	private String createdDate;
	@Column(name="updated_date")
	private String updatedDate;
	@Column(name="size")
	private String size;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(String totalquantity) {
		this.totalquantity = totalquantity;
	}
	public String getSellquantity() {
		return sellquantity;
	}
	public void setSellquantity(String sellquantity) {
		this.sellquantity = sellquantity;
	}
	public String getSerialnummber() {
		return serialnummber;
	}
	public void setSerialnummber(String serialnummber) {
		this.serialnummber = serialnummber;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Long getPcid() {
		return pcid;
	}
	public void setPcid(Long pcid) {
		this.pcid = pcid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", price=" + price + ", totalquantity="
				+ totalquantity + ", sellquantity=" + sellquantity + ", serialnummber=" + serialnummber + ", brandname="
				+ brandname + ", address=" + address + ", code=" + code + ", mid=" + mid + ", subcategory="
				+ subcategory + ", pcid=" + pcid + ", filename=" + filename + ", image=" + image + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", size=" + size + "]";
	}
}
	