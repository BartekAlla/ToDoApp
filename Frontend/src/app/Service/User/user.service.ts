import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {UserInfo} from "../../Model/User/userInfo";
import { BehaviorSubject, Observable } from 'rxjs';
import {Router} from "@angular/router";

@Injectable()
export class UserService {

  private usersUrl: string;
  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient,
              private router: Router) {
    this.usersUrl = 'http://localhost:8080/auth';
  }
  get isLoggedIn$(): Observable<boolean> {
    return this._isLoggedIn$.asObservable();
  }
  public login(userToken: string): void {
    this._isLoggedIn$.next(true);
    localStorage.setItem('userToken', userToken)
    this.gotoUserPage();
  }
  public logout(): void {
    this._isLoggedIn$.next(false);
    localStorage.removeItem('userToken');
    this.router.navigate(['/userlogin']);
  }


  public findAll(): Observable<UserInfo[]> {
    return this.http.get<UserInfo[]>((this.usersUrl).concat('/getUsers'));
  }

  public save(user: UserInfo) {
    user.roles ="ROLE_USER";
    return this.http.post<UserInfo>((this.usersUrl).concat('/addNewUser'), user, { responseType: 'json' });
  }

  getToken(credentials: { username: string, password: string }): Observable<any> {
    return this.http.post((this.usersUrl).concat('/generateToken'), credentials, { responseType: 'json' });
  }
  private gotoUserPage() {
    this.router.navigate([(this.usersUrl).concat('/userpage')]);
  }
}
