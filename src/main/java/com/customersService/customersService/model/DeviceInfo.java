package com.customersService.customersService.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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


public class DeviceInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long deviceId;
	    private DeviceType deviceType;
	    private String deviceName;
	    private String operatingSystem;
	    private String osVersion;
	    private String manufacturer;
	    private String screenResolution;
	    private String screenSize;
	    private String networkInfo;
	    private String browserInfo;
	    private String ipAddress;
	    private String locale;
	    private String timezone;
	    private List<String> deviceFeatures;
	    private DeviceStatus deviceStatus;
	    private List<String> permissions;
	    private String customerId;
	    

}
