package com.capgemini.bookmydoctor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmydoctor.dto.Ratings;
import com.capgemini.bookmydoctor.response.RatingsResponse;
import com.capgemini.bookmydoctor.service.RatingsServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class RatingsController {

	@Autowired
	RatingsServices ratingsServices;

	@PostMapping(path = "/add-ratings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RatingsResponse addRatings(@RequestBody Ratings ratings) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		if (ratingsServices.addRatings(ratings)) {
			ratingsResponse.setStatusCode(201);
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Added Successfully");
		}
		return ratingsResponse;
	}

	@GetMapping(path = "/get-all-ratings", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingsResponse getAllRatings() {
		RatingsResponse ratingsResponse = new RatingsResponse();
		List<Ratings> ratingsList = ratingsServices.getAllRatings();
		if (ratingsList.size() != 0) {
			ratingsResponse.setStatusCode(201);
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Found Successfully");
			ratingsResponse.setRatings(ratingsList);
			return ratingsResponse;
		}
		return ratingsResponse;
	}

	@PutMapping(path = "/modify-ratings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RatingsResponse updateRatings(@RequestBody Ratings ratings) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		if (ratingsServices.updateRatings(ratings)) {
			ratingsResponse.setStatusCode(201);
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Modified Successfully");
		}
		return ratingsResponse;
	}

	@DeleteMapping(path = "/delete-ratings/{ratingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingsResponse deleteRatings(@PathVariable("ratingId") int ratingId) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		if (ratingsServices.deleteRatings(ratingId)) {
			ratingsResponse.setStatusCode(201);
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Deleted Successfully");
		}
		return ratingsResponse;
	}

	@GetMapping(path = "/search-ratings/{ratingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingsResponse searchRatings(@PathVariable("ratingId") int ratingId) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		Ratings ratings = ratingsServices.searchRatings(ratingId);
		if (ratings != null) {
			ratingsResponse.setStatusCode(201);
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Found Successfully");
			ratingsResponse.setRatings(Arrays.asList(ratings));
		}
		return ratingsResponse;
	}

}
