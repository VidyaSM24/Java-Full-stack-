package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.Ratings;

public interface RatingsDao {

	public boolean addRatings(Ratings ratings);

	public boolean updateRatings(Ratings ratings);

	public boolean deleteRatings(int ratingId);

	public Ratings searchRatings(int ratingId);

	public ArrayList<Ratings> getAllRatings();

}
