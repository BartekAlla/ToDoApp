import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserInfo} from "../../Model/User/userInfo";
import {UserService} from "../../Service/User/user.service";
import {MatDatepickerInputEvent} from "@angular/material/datepicker";
import {DatePipe} from "@angular/common";




@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css'],

})
export class UserFormComponent {

  userInfo: UserInfo;
  hide = true;
  passwordType: string = 'password';
  errorMessage: string = '';


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.userInfo = new UserInfo();

  }

  onDateChange(event: MatDatepickerInputEvent<Date>) {
    const selectedDate = event.value;
    if (selectedDate) {
      const formattedDate = new DatePipe('en-US').transform(selectedDate, 'yyyy-MM-dd') ?? '';
      this.userInfo.dateOfBirth = formattedDate;
    }

  }
  onSubmit() {
    this.userService.save(this.userInfo).subscribe((result : any) => {
      if (result.success) {
        this.gotoUserList()
      } else {
        this.errorMessage = result.message;
      }
    });
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
