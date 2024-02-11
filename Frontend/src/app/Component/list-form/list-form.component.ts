import { Component } from '@angular/core';
import {UserList} from "../../Model/UserList/user-list";


@Component({
  selector: 'app-list-form',
  templateUrl: './list-form.component.html',
  styleUrl: './list-form.component.css'
})
export class ListFormComponent {
  userList: UserList;

  constructor() {
    this.userList = new UserList();

  }

  onSubmit() {

  }
}
