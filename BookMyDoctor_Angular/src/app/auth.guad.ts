import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor() { }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const userDetails  = JSON.parse(localStorage.getItem('userDetails'));
    const role = route.data.role;
    console.log(role);
    console.log(userDetails);
    console.log(userDetails.role);
    if (userDetails.adminResponse['0'].role === role) {
         return true;
     } else {
         return false;
     }
  }
}