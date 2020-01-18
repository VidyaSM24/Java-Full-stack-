import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {
  success: string;
  failure: string;
  response: Response;

  constructor(public post: AuthenticationService ) { }

  ngOnInit() {
  }
  addPost(form: NgForm)  {
    this.post.addPost(form.value).subscribe(data => {
      console.log(data);
      this.response = data;
      if (this.response.statusCode === 201) {
        this.success = data.description;
        setTimeout( () => {
          this.success = null;
        }, 20000);
        form.reset();
      } else {
        this.failure = data.description;
        setTimeout (() => {
       this.failure = null;
      }, 2000);
    }
    });
  }
}
