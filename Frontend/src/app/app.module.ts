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
import {FormsModule} from "@angular/forms";
import { HomeComponent } from './Component/home/home.component';
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {MatTabsModule} from "@angular/material/tabs";
import { UserListComponent } from './Component/user-list/user-list.component';
import { UserFormComponent } from './Component/user-form/user-form.component';
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./Service/user-service.service";



@NgModule({
  declarations: [
    AppComponent,
    ToolnavbarComponent,
    HomeComponent,
    UserListComponent,
    UserFormComponent,
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
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
