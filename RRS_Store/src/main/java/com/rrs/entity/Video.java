package com.rrs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table
@Component
public class Video extends Thing{
	@Column
	@NotBlank
	private String director;
	@Column
	@NotBlank
	private String nation;
	@Column
	@NotNull
	private Integer time;
	
	@Override
	public String getDecription() {
		return "This is Video";
	}

}
