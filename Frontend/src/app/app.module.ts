import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from '@angular/material/icon';
import { ToolnavbarComponent } from './toolnavbar/toolnavbar.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {FormsModule} from "@angular/forms";
import { HomeComponent } from './home/home.component';
import {MatListModule} from "@angular/material/list";
import { ShowAllListsComponent } from './show-all-lists/show-all-lists.component';
import { ShowAllUsersComponent } from './show-all-users/show-all-users.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

@NgModule({
  declarations: [
    AppComponent,
    ToolnavbarComponent,
    HomeComponent,
    ShowAllListsComponent,
    ShowAllUsersComponent,
    SignInComponent,
    SignUpComponent
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
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
