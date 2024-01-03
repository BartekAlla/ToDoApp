export class User {
  id: number;
  name: string;
  surname: string;
  gender: string;
  age: number;
  email: string;
  password: string;
  // id: number = 0;
  // name: string = '';
  // surname: string = '';
  // gender: string = '';
  // age: number = 0;
  // email: string = '';
  // password: string = '';

  // constructor(id: number, name: string, surname: string, gender: string, age: number, email: string, password:string) {
  //   this.id = id;
  //   this.name = name;
  //   this.surname = surname;
  //   this.gender = gender;
  //   this.age = age;
  //   this.email = email;
  //   this.password = password;
  // }
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
