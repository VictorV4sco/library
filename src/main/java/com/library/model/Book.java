package com.library.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String author;

	@Column(name = "literary_genre")
	private String literaryGenre;

	@Column
	private Double price;

	public Book() {
	}

	public Book(Long id, String name, String author, String literaryGenre, Double price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.literaryGenre = literaryGenre;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLiteraryGenre() {
		return literaryGenre;
	}

	public void setLiteraryGenre(String literaryGenre) {
		this.literaryGenre = literaryGenre;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, literaryGenre, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(literaryGenre, other.literaryGenre) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}

}
