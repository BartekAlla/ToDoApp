import { Component } from '@angular/core';
import {UserListService} from "../../Service/UserList/user-list.service";
import {UserListLink} from "../../Model/UserListLink/user-list-link";

@Component({
  selector: 'app-my-lists',
  templateUrl: './my-lists.component.html',
  styleUrl: './my-lists.component.css'
})
export class MyListsComponent {
  userLinks: UserListLink[] = [];
  constructor(private listService: UserListService) {
  }

  ngOnInit() {
    this.listService.findCurrentUsersLists().subscribe(data => {
      this.userLinks = data;
    });
  }
}
