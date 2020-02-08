import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AvailabilityService } from '../availability.service';

@Component({
  selector: 'app-add-availabality',
  templateUrl: './add-availabality.component.html',
  styleUrls: ['./add-availabality.component.css']
})
export class AddAvailabalityComponent implements OnInit {

  message: string;
  error: string;
  doctorId1;
  today: Date;
  constructor(private availabilityServive: AvailabilityService) {
    this.today  = new Date();
    console.log(this.today);
    
    let userDet =JSON.parse(localStorage.getItem('userDetails'));
    console.log(userDet.userId);

    this.doctorId1=userDet.userId;
   }

  ngOnInit() {
  }

  addAvailability(form: NgForm) {
    this.availabilityServive.postData(form.value).subscribe(data => {
      console.log(data);
      this.message = data.message;
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });

  }
}
