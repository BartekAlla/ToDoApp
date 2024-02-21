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
  isInputVisible = false;
  newCategory: ListCategory;
  constructor(private categoryService: CategoryService, private taskService: TaskService) {
    this.newCategory = new ListCategory();
  }

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
  toggleCategoryNameInput() {
    this.isInputVisible = !this.isInputVisible;
  }

  addCategory() {
    console.log('Category added successfully:');
    this.isInputVisible = false;
    //TODO ADD LOGIC TO ADD BUTTON
    //   this.categoryName = '';
    // You can call your service here to send the data to the server
    // this.yourService.addCategory(this.categoryName).subscribe(response => {
    //   console.log('Category added successfully:', response);
    //   // Optionally, you can reset the state or perform any other action
    //   this.isInputVisible = false;
    //   this.categoryName = '';
    // });
  }
}

//TODO add button for tasks
