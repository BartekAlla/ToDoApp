import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {UserList} from "../../Model/UserList/user-list";
import {Observable} from "rxjs";

@Injectable()
export class UserListService {

  private listsUrl: string;
  private publicListsUrl: string;

  constructor(private http: HttpClient) {
    this.listsUrl = 'http://localhost:8080/lists';
    this.publicListsUrl = 'http://localhost:8080/lists/public';
  }

  public findAll(): Observable<UserList[]> {
    return this.http.get<UserList[]>(this.listsUrl);
  }
  public findPublic(): Observable<UserList[]> {
    return this.http.get<UserList[]>(this.publicListsUrl);
  }

  public save(list: UserList) {
    return this.http.post<UserList>(this.listsUrl, list);
  }
}
