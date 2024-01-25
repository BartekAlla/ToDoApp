import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserInfo} from "../../Model/User/userInfo";
import {UserService} from "../../Service/User/user.service";


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  userInfo: UserInfo;
  hide = true;
  passwordType: string = 'password';


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.userInfo = new UserInfo();

  }

  onSubmit() {
    this.userService.save(this.userInfo).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/userlogin']);
  }


// Inside your component class
  togglePasswordVisibility(event: Event) {
    event.preventDefault();
    this.passwordType = this.passwordType === 'password' ? 'text' : 'password';
    this.hide = !this.hide;
  }


}
