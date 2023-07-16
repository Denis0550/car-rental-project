import { Component } from '@angular/core';
import {LoginService} from "../../services/login-service/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(
    public loginService: LoginService
  ) {
  }

  getStatusMessage(): string {
    let message = '';
    if (this.loginService.isLoggedIn) {
      message = `Welcome ${this.loginService.name} ${this.loginService.surname}.Dont log out =)`
    } else {
      message = 'Please log in'
    }
    return message;
  }
}
