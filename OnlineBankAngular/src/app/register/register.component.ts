import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  hide = true;
  message : string;
  registerForm : FormGroup;
  email : FormControl;
  username : FormControl;
  password : FormControl;
  passConfirm : FormControl;
  constructor(private UserService:UserService, private router:Router) { }

  ngOnInit(): void {
    this.email = new FormControl('');
    this.username = new FormControl('');
    this.password = new FormControl('');
    this.passConfirm = new FormControl('');
    this.registerForm = new FormGroup({
      email : this.email,
      username : this.username,
      password : this.password,
      passConfirm : this.passConfirm
    });
  }

  register(){
    if(this.registerForm.value.password==this.registerForm.value.passConfirm){
      var user = new User();
      user.email = this.registerForm.value.email;
      user.username = this.registerForm.value.username;
      user.password = this.registerForm.value.password;
      this.UserService.register(user).subscribe(
        (response) => {
          if(response.status==200){
            this.UserService.loggedIn = true;
            this.UserService.user = response.body;
            this.router.navigate(['/Home']);
          }else{
            if(response.body.email && response.body.username){
              this.message="username and email are taken!";
            }else if(response.body.email){
              this.message="email is taken!";
            }else{
              this.message="username is taken!";
            }
          }
        }
      )
    }else{
      this.message="passwords do not match!";
    }
  }
}
