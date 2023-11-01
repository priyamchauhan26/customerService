package com.customersService.customersService.dto;

import java.time.LocalDateTime;

import com.customersService.customersService.model.LocationInfo;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@ToString
public class ProductDto {
    
	private Long id;
    private String productname;
    private String price;
    private String serialnummber;
    private String brandname;
    private String code;
    private String mid;
	private String subcategory;
	private Long pcid;
    private String image;
    private String size;

}
