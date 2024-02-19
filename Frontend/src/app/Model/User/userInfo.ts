export class UserInfo {
  id?: number;
  name?: string;
  surname?: string;
  userGender?: string;
  dateOfBirth?: string;
  roles?: string;
  email?: string;
  password?: string;

  constructor() {
    this.id = 0;
    this.name = '';
    this.surname = '';
    this.userGender = '';
    this.roles = '';
    this.dateOfBirth = '';
    this.email = '';
    this.password = '';
  }

}
