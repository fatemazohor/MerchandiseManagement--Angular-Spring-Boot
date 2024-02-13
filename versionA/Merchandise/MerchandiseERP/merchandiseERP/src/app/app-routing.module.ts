import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ControlWrapperComponent } from './control-wrapper/control-wrapper.component';
import { StyleCategoriesComponent } from './component/sale/style-categories/style-categories.component';
import { SizeComponent } from './component/sale/size/size.component';
import { TrimComponent } from './component/sale/trim/trim.component';
import { RawMaterialCat } from './model/sale.model';
import { StyleComponent } from './component/sale/style/style.component';
import { RawMaterialCategoriesComponent } from './component/sale/raw-material-categories/raw-material-categories.component';
import { MeasurementDetailsComponent } from './component/sale/measurement-details/measurement-details.component';
import { VendorsComponent } from './component/other/vendors/vendors.component';

const routes: Routes = [
  { path: "home", component: HomeComponent},
  { path: "style-categories", component:StyleCategoriesComponent},
  { path: "size", component:SizeComponent},
  { path: "trim", component:TrimComponent},
  { path: "raw-material-categories", component:RawMaterialCategoriesComponent},
  { path: "style", component:StyleComponent},
  { path: "measurement-details", component:MeasurementDetailsComponent},
  { path: "vendors", component:VendorsComponent},
  {path:"dashboard", component:ControlWrapperComponent},
  {path:"**",redirectTo:"/dashboard",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
