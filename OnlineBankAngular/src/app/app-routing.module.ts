import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { AccountDetailComponent } from './account-detail/account-detail.component';


const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'Home', component: HomeComponent},
  {path:'Logout', component: LogoutComponent},
  {path:'Register', component: RegisterComponent},
  {path:'Detail', component: AccountDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
