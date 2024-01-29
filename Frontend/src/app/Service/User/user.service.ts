import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserInfo} from '../../Model/User/userInfo';
import {BehaviorSubject, Observable} from 'rxjs';
import {Router} from '@angular/router';
import {map} from 'rxjs/operators';

@Injectable()
export class UserService {
  private usersUrl: string;
  private userLoggedIn: BehaviorSubject<{ isLoggedIn: string; jwt: string ; id: number}>;

  constructor(private http: HttpClient, private router: Router) {
    this.usersUrl = 'http://localhost:8080/auth';

    const storedUser = localStorage.getItem('user');
    this.userLoggedIn = new BehaviorSubject(
      storedUser
        ? JSON.parse(storedUser)
        : {isLoggedIn: 'false', jwt: '', id: 0}
    );
  }

  get isLoggedIn$(): Observable<boolean> {
    return this.userLoggedIn.asObservable().pipe(
      map((user) => user.isLoggedIn === 'true')
    );
  }

  public getCurrentUserToken() {
    return this.userLoggedIn.value.jwt;
  }

  public login(userToken: string, id: number): void {
    this.userLoggedIn.next({isLoggedIn: 'true', jwt: userToken, id: id});
    localStorage.setItem('user', JSON.stringify(this.userLoggedIn.value));
    this.gotoUserPage();
  }

  public logout(): void {
    this.userLoggedIn.next({isLoggedIn: 'false', jwt: '', id: 0});
    localStorage.setItem('user', JSON.stringify(this.userLoggedIn.value));
    this.router.navigate(['/userlogin']);
  }


  public findAll(): Observable<UserInfo[]> {
    return this.http.get<UserInfo[]>((this.usersUrl).concat('/getUsers'));
  }

  public save(user: UserInfo) {
    user.roles = "ROLE_USER";
    return this.http.post<UserInfo>((this.usersUrl).concat('/addNewUser'), user, {responseType: 'json'});
  }

  getToken(credentials: { username: string, password: string }): Observable<any> {
    return this.http.post((this.usersUrl).concat('/generateToken'), credentials, {responseType: 'json'});
  }

  private gotoUserPage() {
    this.router.navigate(['/userpage']);
  }
}
