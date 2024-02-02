package com.rating.service.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;


@Document
public class Rating {
	@Id
	private int rateId;
	
	private int userId;
	private int hotelId;
	private String ratings;
	private String feedback;
	public int getRateId() {
		return rateId;
	}
	public void setRateId(int rateId) {
		this.rateId = rateId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Rating [rateId=" + rateId + ", userId=" + userId + ", hotelId=" + hotelId + ", ratings=" + ratings
				+ ", feedback=" + feedback + "]";
	}
	
	
}
