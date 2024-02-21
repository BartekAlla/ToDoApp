import {Injectable, NgZone} from '@angular/core';
import {UserService} from "../User/user.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Task} from "../../Model/Task/task";

@Injectable()
export class TaskService {
  private tasksURL: string;
  constructor(private userService: UserService,
              private http: HttpClient,
              private ngZone: NgZone) {
    this.tasksURL = 'http://localhost:8080/tasks';
  }
  getCategoryTasks(categoryId: number) {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.userService.getCurrentUserToken().toString()}`
    });

    return this.http.get<Task[]>(this.tasksURL.concat('/category/', categoryId.toString()),
      {
        headers: headers,
        responseType: 'json'
      });
  }


  changeTaskStatus(task: Task) {
    console.log('changing status');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.userService.getCurrentUserToken().toString()}`
    });

    if (task.taskStatus == 'DONE') {
      task.taskStatus = 'PENDING';
    } else {
      task.taskStatus = 'DONE';
    }

    this.http.put<Task>(this.tasksURL.concat('/', task.id.toString()), task, { headers })
      .subscribe(() => {
        this.ngZone.run(() => {});
      });
  }
}