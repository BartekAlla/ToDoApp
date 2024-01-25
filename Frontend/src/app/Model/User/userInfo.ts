export class UserInfo {
  name: string;
  surname: string;
  gender: string;
  dateOfBirth: Date;
  email: string;
  password: string;

  constructor() {
    this.name = '';
    this.surname = '';
    this.gender = '';
    this.dateOfBirth = new Date();
    this.email = '';
    this.password = '';
  }

}
