package com.customersService.customersService.model;

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
public class Preferences {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long preferencesId;
	private String languagePreference;
    private String currencyPreference;
    private boolean receiveEmailNotifications;
    private boolean receiveSMSNotifications;
    private boolean receivePushNotifications;
    private boolean shareDataForRecommendations;
    private List<String> productInterestCategories;
    private String deliveryPreference;
    private String defaultPaymentMethod;
    private boolean enableTwoFactorAuth;
    private boolean passwordChangeNotifications;
    private String notificationTiming;
    private String displayTheme;
    private String customerId;

}
