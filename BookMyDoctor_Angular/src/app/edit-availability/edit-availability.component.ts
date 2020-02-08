import { Component, OnInit } from '@angular/core';
import { AvailabilityService } from '../availability.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-availability',
  templateUrl: './edit-availability.component.html',
  styleUrls: ['./edit-availability.component.css']
})
export class EditAvailabilityComponent implements OnInit {
  error: string;

  availabilityId1;
  doctorId1;
  fromDate1;
  toDate1;
  availability1;
  today: Date;
  constructor(private availabilityService: AvailabilityService, private router: Router, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {

      this.today = new Date();
      console.log(this.today);

      console.log(data.availabilityId1);
      this.availabilityId1 = data.availabilityId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      // this.availabilityId1 = data.availabilityId;
      this.doctorId1 = data.doctorId;
      this.fromDate1 = data.fromDate;
      this.toDate1 = data.toDate;
      this.availability1 = data.availability;


    });
  }

  ngOnInit() {
  }
  updateAvailability(form: NgForm) {
    this.availabilityService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
        this.router.navigateByUrl('doctor/view-availabilities');
      }
    }, err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });
  }
}
