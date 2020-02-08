import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-login',
  templateUrl: './update-login.component.html',
  styleUrls: ['./update-login.component.css']
})
export class UpdateLoginComponent implements OnInit {
   
  error:string;
  description:string;
    userName1;
    userEmail1;
  
    constructor(private router: Router,
              private service: AuthenticationService) {
    
                let userDet =JSON.parse(localStorage.getItem('userDetails'));
      console.log(userDet.userId);

      this.userName1 = userDet.userName;
      // console.log(this.doctorId1);
      this.userEmail1=userDet.userEmail;
     }
  
    ngOnInit() {
    }
  
    updateUser(form: NgForm) {
      this.service.updateUser(form.value).subscribe(res => {
        console.log(res);
        if (res.statusCode === 201) {
          form.reset();
         // this.router.navigateByUrl('/all-patients');
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
  