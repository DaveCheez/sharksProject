package com.fusionarc.demo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Shark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false)
	private String type;
	
	@Column
	@Min(0)
	@Max(100)
	private int age;
	
	@Column(nullable = false)
	private String origin;
	
	// Default constructor
	public Shark() {}

	// For creating 
	public Shark(String name, String type, @Min(0) @Max(100) int age, String origin) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
		this.origin = origin;
	}

	// For testing
	public Shark(long id, String name, String type, @Min(0) @Max(100) int age, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.origin = origin;
	}
	
	// Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Shark [id=" + id + ", name=" + name + ", type=" + type + ", age=" + age + ", origin=" + origin + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, origin, type);
	}

	//	For testing when comparing objects match
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shark other = (Shark) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(origin, other.origin) && Objects.equals(type, other.type);
	}
	
	
	
}
