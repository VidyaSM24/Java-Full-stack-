import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor(private router : Router) { }

  ngOnInit() {
  }
  
  logout() {
    localStorage.removeItem('userDetails');
    this.router.navigateByUrl('/');
  }
  
  loggedIn() {
    if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
      return true;
    } else {
      return false;
    }
  }
  
  isAdmin() {
    if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
      const userDetails = JSON.parse(localStorage.getItem('userDetails'));
      if (userDetails.role === 'admin') {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
  
  isDoctor() {
    if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
      const userDetails = JSON.parse(localStorage.getItem('userDetails'));
      if (userDetails.role === 'doctor') {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
  
  isPatient() {
    if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
      const userDetails = JSON.parse(localStorage.getItem('userDetails'));
      if (userDetails.role === 'patient') {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }


}
