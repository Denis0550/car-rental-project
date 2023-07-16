import { Component } from '@angular/core';
import {LoginService} from "../../services/login-service/login.service";
import {Router} from "@angular/router";
import {homePageUrl} from "../../models/links";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  message! : string;
  isLoggedIn!: boolean;
  isLoggedOut! :boolean;
  constructor(
    private loginService: LoginService,
    private router: Router
  ) {
    this.updateStatus();
  }
  getStatusMessage(): string {
    let message
    if (this.loginService.isLoggedIn) {
      message = `Welcome ${this.loginService.name} ${this.loginService.surname}. Don't log out:)`
    } else {
      message = 'Please log in'
    }
    return message;
  }
  login() {
    console.log('inside login method()');
    this.message = "Trying to login....";
    this.loginService
    .login('me', 'you')
    .subscribe(value => {
      this.updateStatus();
      this.router.navigateByUrl(homePageUrl)
      .then();
    })
  }
  logout() {
    console.log('inside logout method()');
    this.loginService.logout();
    this.updateStatus();
  }
  private updateStatus() {
    this.message = this.getStatusMessage();
    this.isLoggedIn = this.loginService.isLoggedIn;
    this.isLoggedOut = !this.loginService.isLoggedIn;
  }
}
