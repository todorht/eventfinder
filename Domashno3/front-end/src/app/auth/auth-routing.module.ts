import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NbLogoutComponent, NbRegisterComponent, NbRequestPasswordComponent, NbResetPasswordComponent } from '@nebular/auth';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
    {
      path:'auth',
      children: [
        {
          path: 'login',
          component: LoginComponent,
        },
        {
          path: 'register',
          component: NbRegisterComponent,
        },
        {
          path: 'logout',
          component: NbLogoutComponent,
        },
        {
          path: 'request-password',
          component: NbRequestPasswordComponent,
        },
        {
          path: 'reset-password',
          component: NbResetPasswordComponent,
        },
      ],
    },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {
}
