import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserService} from "../User/user.service";
import {ListCategory} from "../../Model/ListCategory/list-category";
import {UserInfo} from "../../Model/User/userInfo";
import {UserList} from "../../Model/UserList/user-list";

@Injectable()
export class CategoryService {
  private categoriesURL: string;

  constructor(private userService: UserService,
              private http: HttpClient) {
    this.categoriesURL = 'http://localhost:8080/categories';

  }

  getCurrentListCategories() {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.userService.getCurrentUserToken().toString()}`
    });

    return this.http.get<ListCategory[]>(this.categoriesURL.concat('/list/', this.getCurrentList().toString()),
      {
        headers: headers,
        responseType: 'json'
      });
  }

  public getCurrentList() {
    return localStorage.getItem('list') ?? '';
  }

  addCategoryToList(newCategory: ListCategory) {

    delete newCategory.showDoneTasks;
    delete newCategory.tasks;
    delete newCategory.userList.name;
    delete newCategory.userList.listType;
    newCategory.userList.id = Number(localStorage.getItem('list'));
    console.log(newCategory);
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.userService.getCurrentUserToken().toString()}`
    });
    return this.http.post<ListCategory>(this.categoriesURL + '/addNew', newCategory, { headers: headers, responseType: 'json' })
      .subscribe({
        next: response => {
          console.log('Response:', response);
          location.reload();
        },
        error: err => {
          console.error('Error:', err);
        }
      });
  }
}
