import { Component, OnInit } from '@angular/core';
import { RatingService } from '../rating.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-ratings',
  templateUrl: './edit-ratings.component.html',
  styleUrls: ['./edit-ratings.component.css']
})
export class EditRatingsComponent implements OnInit {

  error: string;
  ratingId1;
patientId1;
doctorId1;
ratings1;
feedback1;


  constructor(private ratingService: RatingService, private router: Router, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.ratingId1);
      this.ratingId1 = data.ratingId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      // this.ratingId1 = data.ratingId;
      this.patientId1 = data.patientId;
      this.doctorId1 = data.doctorId;
      this.ratings1 = data.ratings;
      this.feedback1 = data.feedback;
    });
  }

  ngOnInit() {
  }
  updateRating(form: NgForm) {
    this.ratingService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
        this.router.navigateByUrl('all-ratings');
      }
    },  err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });
  }
}