import {Component, OnInit} from '@angular/core';
import {UserList} from "../../Model/UserList/user-list";
import {UserListService} from "../../Service/UserList/user-list.service";

@Component({
  selector: 'app-public-lists',
  templateUrl: './public-lists.component.html',
  styleUrl: './public-lists.component.css'
})
export class PublicListsComponent implements OnInit {
  lists: UserList[] = [];
  constructor(private listService: UserListService) {
  }

  ngOnInit() {
    this.listService.findPublic().subscribe(data => {
      this.lists = data;
    });
  }
}
