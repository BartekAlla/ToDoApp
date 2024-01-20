import {Component, OnInit} from '@angular/core';
import {UserInfo} from "../../Model/User/userInfo";
import {UserService} from "../../Service/User/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {
  users: UserInfo[] = [];
  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }
}
