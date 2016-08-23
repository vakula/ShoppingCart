 package com.niit.shoppingcart.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Product")
@Component
public class Product {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private int id;
private String name;
private String description;
private int price;
@Column(name="image",columnDefinition="varchar(255)")
@Size(min=3,message="please Select the image")
private String image;
@JsonIgnore
transient private MultipartFile img;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public MultipartFile getImg() {
	return img;
}
public void setImg(MultipartFile img) {
	this.img = img;
}

}