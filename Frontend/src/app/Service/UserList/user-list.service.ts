import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserList} from "../../Model/UserList/user-list";
import {BehaviorSubject, Observable} from "rxjs";
import {UserService} from "../User/user.service";
import {UserListLink} from "../../Model/UserListLink/user-list-link";

@Injectable()
export class UserListService {

  private listsUrl: string;
  private publicListsUrl: string;

  constructor(private userService: UserService,
              private http: HttpClient) {
    this.listsUrl = 'http://localhost:8080/lists';
    this.publicListsUrl = 'http://localhost:8080/lists/public';
  }

  public findAll(): Observable<UserList[]> {
    return this.http.get<UserList[]>(this.listsUrl);
  }

  public findPublic(): Observable<UserList[]> {
    return this.http.get<UserList[]>(this.publicListsUrl);
  }

  public findCurrentUsersLists(): Observable<UserListLink[]> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.userService.getCurrentUserToken().toString()}`
    });

    return this.http.get<UserListLink[]>(this.listsUrl.concat('/links/', this.userService.getCurrentUserId().toString()),
      {
        headers: headers,
        responseType: 'json'
      });
  }

  public saveList(list: UserList) {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.userService.getCurrentUserToken().toString()}`
    });
    return this.http.post<UserList>(this.listsUrl, list, {
      headers: headers,
      responseType: 'json'
    });
  }
}
