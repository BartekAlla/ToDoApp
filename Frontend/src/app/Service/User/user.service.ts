import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {UserInfo} from "../../Model/User/userInfo";
import {Observable} from "rxjs";

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/auth';
  }

  public findAll(): Observable<UserInfo[]> {
    return this.http.get<UserInfo[]>((this.usersUrl).concat('/getUsers'));
  }

  public save(user: UserInfo) {
    user.roles ="ROLE_USER";
    return this.http.post<UserInfo>((this.usersUrl).concat('/addNewUser'), user);
  }
}
