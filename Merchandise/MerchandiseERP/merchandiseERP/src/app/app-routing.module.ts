import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ControlWrapperComponent } from './control-wrapper/control-wrapper.component';

const routes: Routes = [
  { path: "home", component: HomeComponent},
  {path:"dashboard", component:ControlWrapperComponent},
  {path:"**",redirectTo:"/dashboard",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
