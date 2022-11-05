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
@Table(name ="BookOnTape")
@Component
public class BookOnTape extends Thing{
	@Column
	@NotBlank
	private String author;
	@Column
	@NotBlank
	private String category;
	@Column
	@NotNull
	private Integer numberOfPages;
	
	@Override
	public String getDecription() {
		return "This is Book On Tape";
	}
	
}
