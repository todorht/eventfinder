import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/event/IEvent';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  username!: string;
  password!: string;

  constructor(private authService: AuthService,
    private router: Router) {

  }

  ngOnInit(): void {
  }

  login(loginForm: any): void {
    this.authService.loginUser({
      username: loginForm.email,
      password: loginForm.password
    });
    this.router.navigate(['/events'])
  }

}
