export class UserInfo {
  name: string;
  surname: string;
  userGender: string;
  dateOfBirth: Date;
  roles: string;
  email: string;
  password: string;

  constructor() {
    this.name = '';
    this.surname = '';
    this.userGender = '';
    this.roles = '';
    this.dateOfBirth = new Date();
    this.email = '';
    this.password = '';
  }

}
