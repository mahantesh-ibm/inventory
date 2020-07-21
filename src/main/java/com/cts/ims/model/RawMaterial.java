package com.cts.ims.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RAW_MATERIAL")
public class RawMaterial implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ITEAM_NAME")
	private String iteamName;
	@Column(name="TYPE")
	private String type;
	@Column(name="QUANTITY")
	private int quantity;
	@Column(name="PRICE_PER_PIECE")
	private double pricePerPiece;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIteamName() {
		return iteamName;
	}
	public void setIteamName(String iteamName) {
		this.iteamName = iteamName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPricePerPiece() {
		return pricePerPiece;
	}
	public void setPricePerPiece(double pricePerPiece) {
		this.pricePerPiece = pricePerPiece;
	}
	@Override
	public String toString() {
		return "RawMaterial [id=" + id + ", iteamName=" + iteamName + ", type=" + type + ", quantity=" + quantity
				+ ", pricePerPiece=" + pricePerPiece + "]";
	}
	
	

}
