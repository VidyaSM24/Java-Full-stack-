import { Component, OnInit } from '@angular/core';
import { RatingService } from '../rating.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-ratings',
  templateUrl: './view-ratings.component.html',
  styleUrls: ['./view-ratings.component.css']
})
export class ViewRatingsComponent implements OnInit {

  description: string;
  ratings: Rating[];


  constructor(private ratingService: RatingService, private router: Router) {
    this.getRatings();

   }

   getRatings() {
     this.ratingService.getData().subscribe(response => {
       console.log(response);
       this.ratings = response.ratings;
     }, err => {
       console.log(err);
     });
   }

deleteRating(rating: Rating) {
    this.ratingService.deleteData(rating).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.ratings.splice(this.ratings.indexOf(rating), 1);
        this.description = response.description;
      }
    });
  }
  deleteMessage() {
    this.description = null;
  }

  selectRating(rating) {
    console.log(rating);
    this.router.navigate([`modify-rating/${rating.ratingId}`],
      {
        queryParams: {
          ratingId: rating.ratingId,
          patientId: rating.patientId,
          doctorId: rating.doctorId,
          ratings: rating.ratings,
          feedback: rating.feedback
        }
      }
    );
  }
  ngOnInit() {
  }
}


