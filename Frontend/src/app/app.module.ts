import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from '@angular/material/icon';
import { ToolnavbarComponent } from './Component/toolnavbar/toolnavbar.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { HomeComponent } from './Component/home/home.component';
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {MatTabsModule} from "@angular/material/tabs";
import { AllUsersComponent } from './Component/all-users/all-users.component';
import { UserFormComponent } from './Component/user-form/user-form.component';
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./Service/User/user.service";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {FormControl, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { UserLoginComponent } from './Component/user-login/user-login.component';
import {MatStepperModule} from '@angular/material/stepper';
import {PublicListsComponent} from "./Component/public-lists/public-lists.component";
import {UserListService} from "./Service/UserList/user-list.service";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import { UserPageComponent } from './Component/user-page/user-page.component';
import { MyListsComponent } from './Component/my-lists/my-lists.component';
import { AboutMeComponent } from './Component/about-me/about-me.component';
import { ListPageComponent } from './Component/list-page/list-page.component';
import { ListFormComponent } from './Component/list-form/list-form.component';



@NgModule({
  declarations: [
    AppComponent,
    ToolnavbarComponent,
    HomeComponent,
    AllUsersComponent,
    UserFormComponent,
    UserLoginComponent,
    PublicListsComponent,
    UserPageComponent,
    MyListsComponent,
    AboutMeComponent,
    ListPageComponent,
    ListFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    FormsModule,
    MatListModule,
    MatCardModule,
    MatTabsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatStepperModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonToggleModule
  ],
  providers: [UserService, UserListService],
  bootstrap: [AppComponent]
})
export class AppModule { }
