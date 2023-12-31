import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ShowAllListsComponent} from "./show-all-lists/show-all-lists.component";
import {ShowAllUsersComponent} from "./show-all-users/show-all-users.component";
import {SignInComponent} from "./sign-in/sign-in.component";
import {SignUpComponent} from "./sign-up/sign-up.component";

const routes: Routes = [
  {
    path: "home", component: HomeComponent
  },
  {
    path: "", component: HomeComponent
  },
  {
    path: "public-lists", component: ShowAllListsComponent
  },
  {
    path: "users", component: ShowAllUsersComponent
  },
  {
    path: "sign-in", component: SignInComponent
  },
  {
    path: "sign-up", component: SignUpComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
