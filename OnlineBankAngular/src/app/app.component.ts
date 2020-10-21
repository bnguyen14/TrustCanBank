import { Component } from '@angular/core';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TrustCan';

  constructor(public UserService:UserService, private Router: Router) {

  }

  get isLoggedIn() : boolean {
    return this.UserService.loggedIn;
  }

  logOut(){
    console.log('logOut executing');
    this.UserService.logout();
    console.log(this.UserService.loggedIn);
    this.Router.navigate(['/Logout']);
  }
}
