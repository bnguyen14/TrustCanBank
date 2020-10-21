import { Injectable } from '@angular/core';
import { User } from './user';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  loggedIn : boolean = false;
  username : string;
  user : User;

  constructor(private httpClient : HttpClient, private router : Router) { }

  get getLoggedInStatus() : boolean {
    return this.loggedIn;
  }

  login(user:User) {
    return this.httpClient.post<User>('http://localhost:8088/user/login',user,{observe: 'response'});
  }

  logout(){
    this.loggedIn = false;
    this.user = null;
    // this.userchange.next('');
  }

  register(user:User){
    console.log("front end: " + user.userName + "," + user.passWord);
    return this.httpClient.post<User>('http://localhost:8088/user/register',user,{observe: 'response'});
  }
}
