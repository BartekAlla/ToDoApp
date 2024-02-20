import {UserList} from "../UserList/user-list";
import {ListCategory} from "../ListCategory/list-category";

export class Task {
  id: number;
  name: string;
  taskStatus: string;
  listCategory: ListCategory;
  constructor() {
    this.id = 0;
    this.name = '';
    this.taskStatus = '';
    this.listCategory = new ListCategory();
  }
}
