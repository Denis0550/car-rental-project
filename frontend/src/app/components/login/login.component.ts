import { Component } from '@angular/core';
import {LoginService} from "../../services/login-service/login.service";
import {Router} from "@angular/router";
import {homePageUrl} from "../../models/links";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  message! : string;
  isLoggedIn!: boolean;
  isLoggedOut! :boolean;

  loginForm = new FormGroup({
    login: new FormControl(''),
    password: new FormControl('')
  })

  loginControl = this.loginForm.controls.login;
  passwordControl = this.loginForm.controls.password;
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
  // TODO: fix navigation link activity
  login() {
    console.log('inside login method()');

    this.message = "Trying to login....";
    this.loginService
    .login(this.loginForm.controls.login.value as string,
      this.loginForm.controls.password.value as string)
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
    this.router.navigateByUrl(homePageUrl)
    .then();
  }

  private updateStatus() {
    this.message = this.getStatusMessage();
    this.isLoggedIn = this.loginService.isLoggedIn;
    this.isLoggedOut = !this.loginService.isLoggedIn;
  }
}
