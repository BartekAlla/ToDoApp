import {Component, OnInit} from '@angular/core';
import {User} from "../../Model/User/user";
import {UserService} from "../../Service/User/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {
  users: User[] = [];
  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }
}
