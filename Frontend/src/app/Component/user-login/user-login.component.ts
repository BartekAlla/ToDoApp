import { Component } from '@angular/core';
import {User} from "../../Model/User/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../Service/User/user.service";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrl: './user-login.component.css'
})
export class UserLoginComponent {

  user: User;
  hide = true;
  passwordType: string = 'password';


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new User();

  }

  onSubmit() {

  }




// Inside your component class
  togglePasswordVisibility(event: Event) {
    event.preventDefault();
    this.passwordType = this.passwordType === 'password' ? 'text' : 'password';
    this.hide = !this.hide;
  }

}
