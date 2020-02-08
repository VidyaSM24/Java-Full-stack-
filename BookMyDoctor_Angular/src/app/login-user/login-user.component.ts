import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

 
  success: string;
  failure: string;
  
  ngOnInit() {

  }

  

  constructor(private auth: AuthenticationService,
              private router: Router) { }

              loginUser(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.success = data.description;
        localStorage.setItem('userDetails', JSON.stringify(data.user['0']));
        if (data.user['0'].role === 'admin') {
          this.router.navigateByUrl('admin');
        } else if (data.user['0'].role === 'doctor') {
          this.router.navigateByUrl('doctor');
        } else {
          this.router.navigateByUrl('patient');
        }
      } else {
        this.failure = data.description;
        console.log('user Details Stored in local Storage');
        setTimeout(() => {
          this.failure = null;
        }, 3000);
        form.reset();
      }
    });
  }

}
