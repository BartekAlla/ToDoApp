import { Injectable } from '@angular/core';
import {UserService} from "../User/user.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserList} from "../../Model/UserList/user-list";
import {UserListLink} from "../../Model/UserListLink/user-list-link";

@Injectable()
export class UserListLinkService {
  private linksUrl: string;
  userListLink: UserListLink;

  constructor(private userService: UserService,
              private http: HttpClient) {
    this.linksUrl = 'http://localhost:8080/ullinks';
    this.userListLink = new UserListLink();
  }
  public saveUserListLink(listId: number) {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.userService.getCurrentUserToken().toString()}`
    });
    delete this.userListLink.userInfo.name;
    delete this.userListLink.userInfo.surname;
    delete this.userListLink.userInfo.userGender;
    delete this.userListLink.userInfo.roles;
    delete this.userListLink.userInfo.dateOfBirth;
    delete this.userListLink.userInfo.email;
    delete this.userListLink.userInfo.password;

    delete this.userListLink.userList.name;
    delete this.userListLink.userList.listType;

    delete this.userListLink.listName;
    this.userListLink.userInfo.id = this.userService.getCurrentUserId();
    this.userListLink.userList.id = listId;
    this.userListLink.listRole = 'OWNER';
    return this.http.post<UserListLink>(this.linksUrl, this.userListLink, {
      headers: headers,
      responseType: 'json'
    });
  }
}
