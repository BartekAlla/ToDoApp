import { Component } from '@angular/core';
import {UserList} from "../../Model/UserList/user-list";
import {UserService} from "../../Service/User/user.service";
import {UserListService} from "../../Service/UserList/user-list.service";
import {Router} from "@angular/router";
import {UserListLinkService} from "../../Service/UserListLink/user-list-link.service";


@Component({
  selector: 'app-list-form',
  templateUrl: './list-form.component.html',
  styleUrl: './list-form.component.css'
})
export class ListFormComponent {
  userList: UserList;

  constructor(private userListService: UserListService,
              private userListLinkService: UserListLinkService,
              private router: Router) {
    this.userList = new UserList();

  }

  onSubmit() {
    this.userListService.saveList(this.userList).subscribe((result: any) => {
      console.log(result.id);
      this.addUserListLink(result.id);
    });
  }

  private addUserListLink(id: number) {
    this.userListLinkService.saveUserListLink(id).subscribe(() => {
      this.gotoMyLists();
    });
  }

  private gotoMyLists() {
    this.router.navigate(['/userpage']);
  }
}




