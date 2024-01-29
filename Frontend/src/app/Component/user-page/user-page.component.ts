import { Component } from '@angular/core';
import {UserService} from "../../Service/User/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrl: './user-page.component.css'
})
export class UserPageComponent {

  
    constructor(private userService: UserService,
                private router: Router) {
      if (!this.userService.getCurrentUserToken()) {
        router.navigate(['/userlogin']);
      }

    }
}
