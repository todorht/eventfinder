import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../event/IEvent';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authUrl = environment.authApi

  currentUser:UserResponse = {
    access_token: "",
    userId:"",
    username:""
  };

  err: string | undefined;

  constructor(private http:HttpClient) {}

  loginUser(user: User){
    this.http.post<UserResponse>(this.authUrl + '/login', user).subscribe({
      next: resposne => this.currentUser = resposne,
      error: err => err = err
    });

  }

  logout(){
    this.currentUser = {
      access_token: "",
      userId:"",
      username:""
    };
  }

  isAuthenticated(){
    return !!this.currentUser;
  }

  getCurrentUser(){
    return this.currentUser;
  }

}

class UserResponse{
  public access_token!: string;
  public userId!: string;
  public username!: string;
}
