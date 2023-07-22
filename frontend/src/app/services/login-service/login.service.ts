import { Injectable } from '@angular/core';
import {delay, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {
  adminRole,
  defaultUserLogin,
  defaultUserName,
  defaultUserSurname,
  emptyRole
} from "../../models/autorization";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  isLoggedIn = false;
  userRole = emptyRole;
  name = defaultUserName;
  surname = defaultUserSurname;
  userLogin = defaultUserLogin;

  constructor(
    private http: HttpClient
  ) {
  }

  login(userLogin: string, pass: string): Observable<boolean> {
    // TODO: delete after tests
    console.log(`userLogin: ${userLogin}, password: ${pass}`)
    return of(true)
    .pipe(
      delay(2000),
      tap(value => {
        this.isLoggedIn = true;
        this.userRole = adminRole;
        this.userLogin = userLogin;
        this.name = 'Maniek';
        this.surname = 'P.';
      })
    )
  }

  logout() {
    this.isLoggedIn = false;
    this.userRole = emptyRole;
    this.name = defaultUserName;
    this.surname = defaultUserSurname;
    this.userLogin = defaultUserLogin;
  }
}
