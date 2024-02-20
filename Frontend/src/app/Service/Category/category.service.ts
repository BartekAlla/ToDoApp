import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserService} from "../User/user.service";
import {ListCategory} from "../../Model/ListCategory/list-category";

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

}
