package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.Availability;

public interface AvailabilityDao {

	public boolean addAvailability(Availability availability);

	public boolean updateAvailability(Availability availability);

	public boolean deleteAvailability(int availabilityId);

	public Availability searchAvailability(int availabilityId);

	public ArrayList<Availability> getAllAvailability();


}