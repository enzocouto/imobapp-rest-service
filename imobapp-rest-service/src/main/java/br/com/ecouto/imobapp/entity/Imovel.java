package br.com.ecouto.imobapp.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Imovel {

	@Id
	private String id;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private String price;
	
	private String title;
	
	private short bedrooms;
	
	private short bathrooms;
	
	private BigDecimal longitude;
	
	private BigDecimal latitude;
	
	private String picture;
	
	private String thumbnail;
	
	private String tags;
	
	private String description;
	
	@DBRef
	private List<ImagemImovel> listaImagem; 
	
	@DBRef
	public Corretor corretor;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public short getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(short bedrooms) {
		this.bedrooms = bedrooms;
	}
	public short getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(short bathrooms) {
		this.bathrooms = bathrooms;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Corretor getCorretor() {
		return corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	public List<ImagemImovel> getListaImagem() {
		return listaImagem;
	}
	public void setListaImagem(List<ImagemImovel> listaImagem) {
		this.listaImagem = listaImagem;
	}
}
