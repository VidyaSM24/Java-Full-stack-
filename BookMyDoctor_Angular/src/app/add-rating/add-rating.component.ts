import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RatingService } from '../rating.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-rating',
  templateUrl: './add-rating.component.html',
  styleUrls: ['./add-rating.component.css']
})
export class AddRatingComponent implements OnInit {

  message: string;
  error:string;
  patientId1;
  doctorId1;

  constructor(private ratingServive: RatingService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {

    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.doctorId1 = data.doctorId;
    });

    let userDet = JSON.parse(localStorage.getItem('userDetails'));
    console.log(userDet.userId);

    this.patientId1 = userDet.userId;
    // this.doctorId1=userDet.userId;


  }

  ngOnInit() {
  }

  addRating(form: NgForm) {
    this.ratingServive.postData(form.value).subscribe(data => {
      console.log(data);
      this.message = data.message;
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
      this.router.navigateByUrl('/patient-inner');
    },  err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });

  }

}
