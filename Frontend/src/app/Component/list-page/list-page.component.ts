import { Component } from '@angular/core';
import {ListCategory} from "../../Model/ListCategory/list-category";
import {CategoryService} from "../../Service/Category/category.service";
import {TaskService} from "../../Service/Task/task.service";

@Component({
  selector: 'app-list-page',
  templateUrl: './list-page.component.html',
  styleUrl: './list-page.component.css'
})
export class ListPageComponent {
  listCategories: ListCategory[] = [];
  constructor(private categoryService:CategoryService,
              private taskService: TaskService) {
  }
  ngOnInit() {
    this.categoryService.getCurrentListCategories().subscribe(data => {
      this.listCategories = data;
    });
   //TODO read tasks for current category
  }
}
