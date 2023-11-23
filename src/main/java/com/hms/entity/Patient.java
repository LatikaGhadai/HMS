package com.hms.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String patientId;
	private String name;
	private String address;
//	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "Invalid email address")
    private String email;
	private String mobile;
	

}
