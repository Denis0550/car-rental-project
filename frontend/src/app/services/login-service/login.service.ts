import {inject, Injectable} from '@angular/core';
import {delay, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {
  adminRole,
  defaultUserLogin,
  defaultUserName,
  defaultUserSurname,
  emptyRole
} from "../../models/autorization";
import {Router} from "@angular/router";
import {loginPageUrl} from "../../models/links";

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

  isAdmin(): boolean {
    return this.userRole === adminRole;
  }

  login(userLogin: string, pass: string): Observable<boolean> {
    // TODO: delete after tests
    console.log(`userLogin: ${userLogin}, password: ${pass}`)

    // null vs undefined
    // let nullVariable = null;
    // let emptyVariable;
    // console.log(`nullVariable value: ${nullVariable}`);
    // console.log(`emptyVariable value: ${emptyVariable}`);

    return of(true)
    .pipe(
      delay(2000),
      tap(value => {
        this.isLoggedIn = true;
        this.userRole = adminRole;
        this.userLogin = userLogin;
        this.name = 'Den';
        this.surname = 'Sor';
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


export const authGuard = () => {
  const loginService = inject(LoginService);
  const router: Router = inject(Router);

  if (loginService.isAdmin()) {
    return true;
  }
  return router.createUrlTree([loginPageUrl]);
}
