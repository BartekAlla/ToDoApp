import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./Component/home/home.component";
import {AllUsersComponent} from "./Component/all-users/all-users.component";
import {UserFormComponent} from "./Component/user-form/user-form.component";
import {UserLoginComponent} from "./Component/user-login/user-login.component";
import {PublicListsComponent} from "./Component/public-lists/public-lists.component";

const routes: Routes = [
  {
    path: "home", component: HomeComponent
  },
  {
    path: "", component: HomeComponent
  },
  {path: 'users', component: AllUsersComponent},
  {path: 'adduser', component: UserFormComponent},
  {path: 'userlogin', component: UserLoginComponent},
  {path: 'publiclists', component: PublicListsComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
