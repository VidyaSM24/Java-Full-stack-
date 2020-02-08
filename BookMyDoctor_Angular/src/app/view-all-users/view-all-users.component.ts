import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-users',
  templateUrl: './view-all-users.component.html',
  styleUrls: ['./view-all-users.component.css']
})
export class ViewAllUsersComponent implements OnInit {

  description: string;
  users: User[];


  constructor(private aunticationService: AuthenticationService, private router: Router) {
    this.getUsers();

   }

   getUsers() {
     this.aunticationService.getData().subscribe(response => {
       console.log(response);
       this.users = response.user;
     }, err => {
       console.log(err);
     });
   }

deleteUser(user: User) {
    this.aunticationService.deleteUser(user).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.users.splice(this.users.indexOf(user), 1);
        this.description = response.description;
      }
    });
  }
  deleteMessage() {
    this.description = null;
  }

  selectDoctor(user) {
    console.log(user);
    this.router.navigate([`modify-user/${user.userEmail}`],
      {
        queryParams: {
          userEmail: user.userEmail,
          userName: user.userName,
          userPassword: user.userPassword,
        }
      }
    );
  }
  ngOnInit() {
  }
}


