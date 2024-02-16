import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ControlWrapperComponent } from './control-wrapper/control-wrapper.component';
import { StyleCategoriesComponent } from './component/sale/style-categories/style-categories.component';
import { SizeComponent } from './component/sale/size/size.component';
import { TrimComponent } from './component/sale/trim/trim.component';
import { Department, OrderStatus, RawMaterialCat, StockAdjustment } from './model/sale.model';
import { StyleComponent } from './component/sale/style/style.component';
import { RawMaterialCategoriesComponent } from './component/sale/raw-material-categories/raw-material-categories.component';
import { MeasurementDetailsComponent } from './component/sale/measurement-details/measurement-details.component';
import { VendorsComponent } from './component/other/vendors/vendors.component';
import { UomComponent } from './component/other/uom/uom.component';
import { DepartmentComponent } from './component/other/department/department.component';
import { LaborCostComponent } from './component/other/labor-cost/labor-cost.component';
import { WarehouseComponent } from './component/inventory/warehouse/warehouse.component';
import { PurchaseStatusComponent } from './component/inventory/purchase-status/purchase-status.component';
import { StockAdjustmentComponent } from './component/inventory/stock-adjustment/stock-adjustment.component';
import { OrderStatusComponent } from './component/inventory/order-status/order-status.component';

const routes: Routes = [
  { path: "home", component: HomeComponent},
  { path: "style-categories", component:StyleCategoriesComponent},
  { path: "size", component:SizeComponent},
  { path: "trim", component:TrimComponent},
  { path: "raw-material-categories", component:RawMaterialCategoriesComponent},
  { path: "style", component:StyleComponent},
  { path: "measurement-details", component:MeasurementDetailsComponent},

  //----------------------------------- Other------------------------------------------------------

  { path: "vendors", component:VendorsComponent},
  { path: "uom", component:UomComponent},
  { path: "department", component:DepartmentComponent},
  { path: "labor-cost", component:LaborCostComponent},

  //---------------------------------- Inventory----------------------------------------------------------
  
  { path: "warehouse", component:WarehouseComponent},
  { path: "purchase_status", component:PurchaseStatusComponent},
  { path: "stock_adjustment", component:StockAdjustmentComponent},

  //---------------------------------- Buyers--------------------------------------------------------------

  { path: "order_status", component:OrderStatusComponent},

  //---------------------------------- Dashboard--------------------------------------------------------------
  
  {path:"dashboard", component:ControlWrapperComponent},
  {path:"**",redirectTo:"/dashboard",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
