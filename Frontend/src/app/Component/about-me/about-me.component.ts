import { Component } from '@angular/core';
import {UserInfo} from "../../Model/User/userInfo";
import {UserService} from "../../Service/User/user.service";

@Component({
  selector: 'app-about-me',
  templateUrl: './about-me.component.html',
  styleUrl: './about-me.component.css'
})
export class AboutMeComponent {
  user: UserInfo = new UserInfo();
  constructor(private userService: UserService) {
  }
  ngOnInit() {
      this.userService.getCurrentUser().subscribe(data => {
        this.user = data;
      });
  }
}
