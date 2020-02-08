import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register-patient',
  templateUrl: './register-patient.component.html',
  styleUrls: ['./register-patient.component.css']
})
export class RegisterPatientComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private auth: AuthenticationService) { }

  ngOnInit() {
  }

  registerUser(form: NgForm) {
    this.auth.registerUser({...form.value, role: 'patient'}).subscribe(data => {
      console.log(data);

      if(data.statusCode === 201){
        this.success = data.description;
        setTimeout(() => {
          this.success = null;
        }, 2000);
        form.reset();
      } else {
        this.failure = data.description
        ;
        setTimeout(() => {
          this.failure = null;
        },2000);
      }
    });
  }


}
