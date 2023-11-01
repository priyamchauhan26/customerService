package com.customersService.customersService.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@ToString
public class LocationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long locationid;
	 private double latitude;
	    private double longitude;
	    private String locationName;
	    private String streetAddress;
	    private String city;
	    private String stateProvince;
	    private String country;
	    private String postalCode;
	    private double accuracy;
	    private double altitude;
	    private double heading;
	    private double speed;
	    private LocalDateTime timestamp;
	    private String deviceId;

}
