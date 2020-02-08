import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  message: string;
  error:string;
  constructor(private doctorServive: DoctorService) { }

  ngOnInit() {
  }

  addDoctor(form: NgForm) {
    this.doctorServive.postData(form.value).subscribe(data => {
      console.log(data);
      this.message = data.message;
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
    },  err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });

  }

}