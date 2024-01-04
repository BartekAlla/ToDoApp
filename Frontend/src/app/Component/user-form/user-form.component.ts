import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from "../../Model/User/user";
import {UserService} from "../../Service/User/user.service";


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  user: User;
  hide = true;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new User();

  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
  isLinear = false;

  toggleLinear() {
    this.isLinear = !this.isLinear;
  }

}
