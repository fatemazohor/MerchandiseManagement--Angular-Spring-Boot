import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ControlWrapperComponent } from './control-wrapper/control-wrapper.component';
import { StyleCategoriesComponent } from './component/sale/style-categories/style-categories.component';
import { SizeComponent } from './component/sale/size/size.component';
import { TrimComponent } from './component/sale/trim/trim.component';
import { Department, OrderStatus, RawMaterialCat, StockAdjustment, StyleMaterialQty } from './model/sale.model';
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
import { TaskComponent } from './component/inventory/task/task.component';
import { BuyerComponent } from './component/buyers/buyer/buyer.component';
import { OrderDetailsComponent } from './component/buyers/order-details/order-details.component';
import { RawMaterialComponent } from './component/sale/raw-material/raw-material.component';
import { MeasurementAttachmentComponent } from './component/sale/measurement-attachment/measurement-attachment.component';
import { StyleAttachmentComponent } from './component/sale/style-attachment/style-attachment.component';
import { StocksComponent } from './component/inventory/stocks/stocks.component';
import { StyleMaterialQtyComponent } from './component/sale/style-material-qty/style-material-qty.component';
import { AdjustmentMaterialComponent } from './component/inventory/adjustment-material/adjustment-material.component';
import { PurchaseComponent } from './component/inventory/purchase/purchase.component';
import { StyleBomComponent } from './component/reports/style-bom/style-bom.component';
import { BomMaterialComponent } from './component/reports/bom-material/bom-material.component';

const routes: Routes = [
  { path: "home", component: HomeComponent},
  { path: "style-categories", component:StyleCategoriesComponent},
  { path: "size", component:SizeComponent},
  { path: "trim", component:TrimComponent},
  { path: "raw-material", component:RawMaterialComponent},
  { path: "raw-material-categories", component:RawMaterialCategoriesComponent},
  { path: "style", component:StyleComponent},
  { path: "style-attachment", component:StyleAttachmentComponent},
  { path: "measurement-details", component:MeasurementDetailsComponent},
  { path: "measurement-attachment", component:MeasurementAttachmentComponent},
  { path: "style-material-qty", component:StyleMaterialQtyComponent},

  //----------------------------------- Other------------------------------------------------------

  { path: "vendors", component:VendorsComponent},
  { path: "uom", component:UomComponent},
  { path: "department", component:DepartmentComponent},
  { path: "labor-cost", component:LaborCostComponent},

  //---------------------------------- Inventory----------------------------------------------------------
  
  { path: "warehouse", component:WarehouseComponent},
  { path: "purchase_status", component:PurchaseStatusComponent},
  { path: "purchase", component:PurchaseComponent},
  { path: "adjustment_material", component:AdjustmentMaterialComponent},
  { path: "stock_adjustment", component:StockAdjustmentComponent},
  { path: "stock", component:StocksComponent},

  //---------------------------------- Buyers--------------------------------------------------------------

  { path: "order_status", component:OrderStatusComponent},
  { path: "task", component:TaskComponent},
  { path: "buyers", component:BuyerComponent},
  { path: "orders", component:OrderDetailsComponent},

  //---------------------------------- Report----------------------------------------------------------------
  { path: "style-bom", component:StyleBomComponent},
  { path: "bom/:id", component:BomMaterialComponent},
  //---------------------------------- Dashboard--------------------------------------------------------------
  
  {path:"dashboard", component:ControlWrapperComponent},
  {path:"**",redirectTo:"/dashboard",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
