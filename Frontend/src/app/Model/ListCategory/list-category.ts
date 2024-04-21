import { UserList } from "../UserList/user-list";
import { Task } from "../Task/task";

export class ListCategory {
  id: number;
  name: string;
  userList: UserList;
  tasks?: Task[];
  showDoneTasks?: boolean;
  showTaskInput?: boolean;

  constructor() {
    this.id = 0;
    this.name = '';
    this.userList = new UserList();
    this.tasks = [];
    this.showDoneTasks = false;
    this.showTaskInput = false;
  }
}
