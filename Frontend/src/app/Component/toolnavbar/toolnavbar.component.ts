import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../Service/User/user.service';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-toolnavbar',
  templateUrl: './toolnavbar.component.html',
  styleUrls: ['./toolnavbar.component.css']
})
export class ToolnavbarComponent implements OnInit {
  opened = false;
  isLoggedIn = false;

  constructor(private router: Router, private userService: UserService) {}

  ngOnInit(): void {
    this.userService.isLoggedIn$.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    });
  }

  logout() {
    this.userService.logout();
  }

  redirectOnProfileIconClick() {
    this.userService.getCurrentUserId() == 0 ? this.router.navigate(['/userlogin']) : this.router.navigate(['/userpage']) ;

  }
}



