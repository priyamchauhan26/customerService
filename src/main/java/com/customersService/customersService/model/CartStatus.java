package com.customersService.customersService.model;

public enum CartStatus {
	
	
	    OPEN,           // The cart is open and items can be added or removed.
	    CHECKOUT,       // The customer is in the checkout process.
	    ABANDONED,      // The cart was abandoned by the customer.
	    SUBMITTED,      // The order has been submitted and is awaiting processing.
	    EXPIRED,        // The cart has expired due to inactivity or a time limit.
	    ORDERED,        // The order has been placed and is awaiting fulfillment.
	    COMPLETED,      // The order has been successfully fulfilled and completed.
	    CANCELED        // The customer has canceled the order or cart.
	

}
