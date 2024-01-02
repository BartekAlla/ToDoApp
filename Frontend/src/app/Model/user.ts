export class User {
  id: number;
  name: string;
  surname: string;
  gender: string;
  age: number;
  email: string;
  password: string;
  constructor() {
    this.id = 0;
    this.name = '';
    this.surname = '';
    this.gender = '';
    this.age = 0;
    this.email = '';
    this.password = '';
  }
}
