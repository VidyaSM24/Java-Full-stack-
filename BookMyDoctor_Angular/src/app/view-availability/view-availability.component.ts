import { Component, OnInit } from '@angular/core';
import { RatingService } from '../rating.service';
import { Router } from '@angular/router';
import { AvailabilityService } from '../availability.service';

@Component({
  selector: 'app-view-availability',
  templateUrl: './view-availability.component.html',
  styleUrls: ['./view-availability.component.css']
})
export class ViewAvailabilityComponent implements OnInit {

 
  description: string;
   availabilities: Availability[];


  constructor(private availabilityService: AvailabilityService, private router: Router) {
    this.getAvailabilities();

   }

   getAvailabilities() {
     this.availabilityService.getData().subscribe(response => {
       console.log(response);
       this.availabilities = response.availability;
     }, err => {
       console.log(err);
     });
   }

   deleteAvailability(availability: Availability) {
    this.availabilityService.deleteData(availability).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.availabilities.splice(this.availabilities.indexOf(availability), 1);
        this.description = response.description;
      }
    });
  }
  deleteMessage() {
    this.description = null;
  }

  selectAvailability(availability) {
    console.log(availability);
    this.router.navigate([`modify-availability/${availability.availabilityId}`],
      {
        queryParams: {
          availabilityId: availability.availabilityId,
          doctorId: availability.doctorId,
          fromDate: availability.fromDate,
          toDate: availability.toDate,
          availability: availability.availability
        }
      }
    );
  }
  ngOnInit() {
  }
}

