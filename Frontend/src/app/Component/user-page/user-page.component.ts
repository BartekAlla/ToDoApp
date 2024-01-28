import { Component } from '@angular/core';
import {UserService} from "../../Service/User/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrl: './user-page.component.css'
})
export class UserPageComponent {

    isLoggedIn = false;
    constructor(private userService: UserService,
                private router: Router) {
      // this.userService.isLoggedIn$.subscribe((isLoggedIn) => {
      //   this.isLoggedIn = isLoggedIn;
      //   if (!isLoggedIn) {
      //     this.router.navigate(['/userlogin']);
      //   }
      // })
      if (!this.userService.getCurrentUserToken()) {
        router.navigate(['/userlogin']);
      }

    }
}
