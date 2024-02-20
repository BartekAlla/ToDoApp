import {UserList} from "../UserList/user-list";

export class ListCategory {
  id: number;
  name: string;
  userList: UserList;
  constructor() {
    this.id = 0;
    this.name = '';
    this.userList = new UserList();
  }
}
