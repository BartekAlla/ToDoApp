import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./Component/home/home.component";
import {UserListComponent} from "./Component/user-list/user-list.component";
import {UserFormComponent} from "./Component/user-form/user-form.component";

const routes: Routes = [
  {
    path: "home", component: HomeComponent
  },
  {
    path: "", component: HomeComponent
  },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
