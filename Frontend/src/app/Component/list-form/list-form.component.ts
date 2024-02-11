import { Component } from '@angular/core';
import {UserList} from "../../Model/UserList/user-list";
import {UserService} from "../../Service/User/user.service";
import {UserListService} from "../../Service/UserList/user-list.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-list-form',
  templateUrl: './list-form.component.html',
  styleUrl: './list-form.component.css'
})
export class ListFormComponent {
  userList: UserList;

  constructor(private userListService: UserListService,
              private router: Router) {
    this.userList = new UserList();

  }

  onSubmit() {
    console.log('Form Submitted');
    this.userListService.saveList(this.userList).subscribe( (result : any) => {
      if (result.success) {
        this.gotoMyLists();
      }
    });
  }

  private gotoMyLists() {
    this.router.navigate(['/userpage']);
  }
}
