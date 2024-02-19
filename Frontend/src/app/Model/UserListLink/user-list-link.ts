import {UserInfo} from "../User/userInfo";
import {UserList} from "../UserList/user-list";

export class UserListLink {
  userInfo: UserInfo;
  userList: UserList;
  listRole: string;
  listName?: string;
  constructor() {
    this.userInfo = new UserInfo();
    this.userList = new UserList();
    this.listRole = '';
    this.listName = '';
  }
}
