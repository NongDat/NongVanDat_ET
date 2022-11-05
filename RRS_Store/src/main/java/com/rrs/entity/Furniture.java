package com.rrs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name ="Furniture")
@Component
public class Furniture extends Thing{
	@Column
	@NotBlank
	private String color;
	@Column
	@NotBlank
	private String material;
	@Column
	@NotNull
	private Integer width; 
	@Column
	@NotNull
	private Integer height; 
	
	@Override
	public String getDecription() {
		return "This is Furniture";
	}

}
