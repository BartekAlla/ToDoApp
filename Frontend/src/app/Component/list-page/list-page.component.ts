import {Component} from '@angular/core';
import {ListCategory} from "../../Model/ListCategory/list-category";
import {CategoryService} from "../../Service/Category/category.service";
import {TaskService} from "../../Service/Task/task.service";
import {Task} from "../../Model/Task/task";
import {UserListLinkService} from "../../Service/UserListLink/user-list-link.service";
import {ListRole} from "../../Enum/list-role";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Component({
  selector: 'app-list-page',
  templateUrl: './list-page.component.html',
  styleUrls: ['./list-page.component.css']
})
export class ListPageComponent {
  listCategories: ListCategory[] = [];
  isCategoryInputVisible = false;
  newCategory: ListCategory;
  newTask: Task;
  currentUserRoleInCurrentList: ListRole;

  constructor(private categoryService: CategoryService, private taskService: TaskService, private userListLinkService: UserListLinkService) {
    this.newCategory = new ListCategory();
    this.newTask = new Task();
    this.currentUserRoleInCurrentList = ListRole.VIEWER;
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
    this.isCategoryInputVisible = !this.isCategoryInputVisible;
  }

  addCategory() {
    this.isCategoryInputVisible = false;
    this.categoryService.addCategoryToList(this.newCategory);
  }

  toggleTaskNameInput(category: ListCategory) {
    category.showTaskInput = !category.showTaskInput;
  }

  addTask(category: ListCategory) {
    category.showTaskInput = false;
    this.taskService.addTaskToList(category.id, this.newTask);
  }


  //TODO GIVE ONLY USER WITH EDITOR OR OWNER ROLE POSSIBILITY TO EDIT LIST
   public checkIfCurrentUserHasPermission()  {

    // return this.userListLinkService.checkIfCurrentUserHasPermission().pipe(
    //   map(data => !!data)
    // );
    return true;
  }

}


