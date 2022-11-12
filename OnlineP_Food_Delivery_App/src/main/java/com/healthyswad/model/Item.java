package com.healthyswad.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private String description;
	private Double cost;
	private String imageUrl;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category = new Category();

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Restaurant> restaurants = new ArrayList<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(description, other.description)
				&& Objects.equals(itemName, other.itemName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, description, itemName);
	}

	

}
