import { Component } from '@angular/core';
import {UserListService} from "../../Service/UserList/user-list.service";
import {UserListLink} from "../../Model/UserListLink/user-list-link";
import {Router} from "@angular/router";

@Component({
  selector: 'app-my-lists',
  templateUrl: './my-lists.component.html',
  styleUrl: './my-lists.component.css'
})
export class MyListsComponent {
  userLinks: UserListLink[] = [];
  constructor(private listService: UserListService,
              private router: Router) {
  }

  ngOnInit() {
    this.listService.findCurrentUsersLists().subscribe(data => {
      this.userLinks = data;
    });
  }

  saveSelectedList(id: number) {
    localStorage.setItem('list', JSON.stringify(id));
  }

  addNewList() {
    this.router.navigate(['/newList']);
  }
}
