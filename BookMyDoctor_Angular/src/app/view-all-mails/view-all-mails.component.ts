import { Component, OnInit } from '@angular/core';
import { MailService } from '../mail.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-mails',
  templateUrl: './view-all-mails.component.html',
  styleUrls: ['./view-all-mails.component.css']
})
export class ViewAllMailsComponent implements OnInit {


  description: string;
   mails: Mail[];


  constructor(private mailService: MailService, private router: Router) {
    this.getMails();

   }

   getMails() {
     this.mailService.getData().subscribe(response => {
       console.log(response);
       this.mails = response.mail;
     }, err => {
       console.log(err);
     });
   }

   deleteMail(mail: Mail) {
    this.mailService.deleteData(mail).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.mails.splice(this.mails.indexOf(mail), 1);
        this.description = response.description;
      }
    });
  }
  deleteMessage() {
    this.description = null;
  }
  ngOnInit() {
  }
}