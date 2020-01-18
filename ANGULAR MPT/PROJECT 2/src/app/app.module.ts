import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { PostsComponent } from './posts/posts.component';
import { AddPostComponent } from './add-post/add-post.component';
import { HeaderComponent } from './header/header.component';
import { DeletePostComponent } from './delete-post/delete-post.component';
import { DisplayPostComponent } from './display-post/display-post.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PostsComponent,
    AddPostComponent,
    HeaderComponent,
    DeletePostComponent,
    DisplayPostComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent},
      { path: 'add-post', component: AddPostComponent},
      {path: 'delete-post',component:DeletePostComponent},
      {path:'display-post',component:DisplayPostComponent}

    
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
