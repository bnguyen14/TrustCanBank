import { Injectable } from '@angular/core';
import { User } from './user';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Userlogin } from './userlogin';
import { Account } from './account';
import { Transaction } from './transaction';
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

  login(userlogin:Userlogin) {
    return this.httpClient.post<User>('http://localhost:8080/api/users/login',userlogin,{observe: 'response'});
  }

  logout(){
    this.loggedIn = false;
    this.user = null;
    // this.userchange.next('');
  }

  register(user:User){
    return this.httpClient.post<User>('http://localhost:8080/api/users/addUser',user,{observe: 'response'});
  }
  getAccounts(userId:Number){
    return this.httpClient.get<Account[]>('http://localhost:8080/api/accounts/listAccountsByUser'+userId,{observe: 'response'});
  }
  getTransactions(accountId:Number){
    return this.httpClient.get<Transaction[]>('http://localhost:8080/api/accounts/listByTransaction'+accountId,{observe: 'response'});
  }
}
