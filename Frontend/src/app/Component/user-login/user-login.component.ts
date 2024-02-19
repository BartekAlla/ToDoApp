import {Component} from '@angular/core';
import {UserInfo} from "../../Model/User/userInfo";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../Service/User/user.service";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrl: './user-login.component.css'
})
export class UserLoginComponent {

  userInfo: UserInfo;
  hide = true;
  passwordType: string = 'password';
  errorMessage: string = '';


  constructor(
    private route: ActivatedRoute,
    private userService: UserService) {
    this.userInfo = new UserInfo();

  }

  onSubmit() {
    const credentials = {
      username: this.userInfo.email ?? '',
      password: this.userInfo.password ?? ''
    };
    this.userService.getToken(credentials).subscribe((result: any) => {
      if (result.success) {

        this.userService.login(result.message, result.id);
      } else {
        this.errorMessage = result.message;
      }
    });
  }

  togglePasswordVisibility(event: Event) {
    event.preventDefault();
    this.passwordType = this.passwordType === 'password' ? 'text' : 'password';
    this.hide = !this.hide;
  }
}
