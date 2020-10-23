import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  accounts:Account[];

  constructor(public UserService:UserService, private Router: Router) { }
  
  ngOnInit(): void {
    this.UserService.getAccounts(this.UserService.user.userId).subscribe(
      (response) => {
        this.accounts = response.body;
      }
    )
  }

  goToDetail(id:Number){
    this.Router.navigate(['/Detail'],{state:{id:id}});
  }
}
