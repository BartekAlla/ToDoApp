import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {UserInfo} from "../../Model/User/userInfo";
import { BehaviorSubject, Observable } from 'rxjs';
import {Router} from "@angular/router";

@Injectable()
export class UserService {

  private usersUrl: string;
  private userLoggedIn: {isLoggedIn: string, jwtToken: string};

  constructor(private http: HttpClient,
              private router: Router) {
    this.usersUrl = 'http://localhost:8080/auth';
    this.userLoggedIn = {isLoggedIn: 'false', jwtToken: ''};
    localStorage.setItem('user', JSON.stringify(this.userLoggedIn));
  }
  public isLoggedIn() {
    return JSON.parse(localStorage.getItem('user') || '{"isLoggedIn": "false"}').isLoggedIn;
  }
  public getCurrentUserToken() {
    return localStorage.getItem('userToken');
  }
  public login(userToken: string): void {
    this.userLoggedIn = {isLoggedIn: 'true', jwtToken: userToken};
    localStorage.setItem('user', JSON.stringify(this.userLoggedIn));
    this.gotoUserPage();
  }
  public logout(): void {
    this.userLoggedIn = {isLoggedIn: 'false', jwtToken: ''};
    localStorage.setItem('user', JSON.stringify(this.userLoggedIn));
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
