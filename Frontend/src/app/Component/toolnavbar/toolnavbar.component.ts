import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../Service/User/user.service";


@Component({
  selector: 'app-toolnavbar',
  templateUrl: './toolnavbar.component.html',
  styleUrl: './toolnavbar.component.css'
})
export class ToolnavbarComponent {
  opened = false;
  isLoggedIn = false;


  constructor(private router: Router, private userService: UserService) {
    this.isLoggedIn = this.userService.isLoggedIn();
  }
  logout() {
    this.userService.logout();
  }
}
