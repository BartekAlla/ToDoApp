import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./Component/home/home.component";
import {AllUsersComponent} from "./Component/all-users/all-users.component";
import {UserFormComponent} from "./Component/user-form/user-form.component";
import {UserLoginComponent} from "./Component/user-login/user-login.component";
import {PublicListsComponent} from "./Component/public-lists/public-lists.component";
import {UserPageComponent} from "./Component/user-page/user-page.component";
import {AboutMeComponent} from "./Component/about-me/about-me.component";
import {ListPageComponent} from "./Component/list-page/list-page.component";
import {ListFormComponent} from "./Component/list-form/list-form.component";

const routes: Routes = [
  {
    path: "home", component: HomeComponent
  },
  {
    path: "", component: HomeComponent
  },
  {path: 'adduser', component: UserFormComponent},
  {path: 'userlogin', component: UserLoginComponent},
  {path: 'userpage', component: UserPageComponent},
  {path: 'aboutme', component: AboutMeComponent},
  {path: 'listpage', component: ListPageComponent},
  {path: 'newList', component: ListFormComponent},
  {path: 'publiclists', component: PublicListsComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
