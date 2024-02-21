import { Component } from '@angular/core';
import { ListCategory } from "../../Model/ListCategory/list-category";
import { CategoryService } from "../../Service/Category/category.service";
import { TaskService } from "../../Service/Task/task.service";
import { Task } from "../../Model/Task/task";

@Component({
  selector: 'app-list-page',
  templateUrl: './list-page.component.html',
  styleUrls: ['./list-page.component.css']
})
export class ListPageComponent {
  listCategories: ListCategory[] = [];
  showDoneTasks: boolean = false;

  constructor(private categoryService: CategoryService, private taskService: TaskService) {}

  ngOnInit() {
    this.categoryService.getCurrentListCategories().subscribe(data => {
      this.listCategories = data;


      this.listCategories.forEach(category => {
        this.taskService.getCategoryTasks(category.id).subscribe(tasks => {
          category.tasks = tasks;
        });
      });
    });
  }
  toggleShowDoneTasks(category: any) {
    category.showDoneTasks = !category.showDoneTasks;
  }

  onCheckboxChange(task: Task) {
      this.taskService.changeTaskStatus(task);
  }
}
//TODO add button for categories
//TODO add button for tasks
