import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainHeaderComponent } from './main-header/main-header.component';
import { MainSidebarComponent } from './main-sidebar/main-sidebar.component';
import { ControlSidebarComponent } from './control-sidebar/control-sidebar.component';
import { MainFooterComponent } from './main-footer/main-footer.component';
import { ControlWrapperComponent } from './control-wrapper/control-wrapper.component';
import { HomeComponent } from './home/home.component';
import { StyleCategoriesComponent } from './component/sale/style-categories/style-categories.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SizeComponent } from './component/sale/size/size.component';
import { TrimComponent } from './component/sale/trim/trim.component';
import { RawMaterialCategoriesComponent } from './component/sale/raw-material-categories/raw-material-categories.component';
import { StyleComponent } from './component/sale/style/style.component';
import { MeasurementDetailsComponent } from './component/sale/measurement-details/measurement-details.component';
import { PaginationComponent } from './component/sale/pagination/pagination.component';
import { VendorsComponent } from './component/other/vendors/vendors.component';
import { UomComponent } from './component/other/uom/uom.component';
import { DepartmentComponent } from './component/other/department/department.component';
import { LaborCostComponent } from './component/other/labor-cost/labor-cost.component';
import { WarehouseComponent } from './component/inventory/warehouse/warehouse.component';
import { PurchaseStatusComponent } from './component/inventory/purchase-status/purchase-status.component';
import { StockAdjustmentComponent } from './component/inventory/stock-adjustment/stock-adjustment.component';
import { OrderStatusComponent } from './component/inventory/order-status/order-status.component';
import { TaskComponent } from './component/inventory/task/task.component';


@NgModule({
  declarations: [
    AppComponent,
    MainHeaderComponent,
    MainSidebarComponent,
    ControlSidebarComponent,
    MainFooterComponent,
    ControlWrapperComponent,
    HomeComponent,
    StyleCategoriesComponent,
    SizeComponent,
    TrimComponent,
    RawMaterialCategoriesComponent,
    StyleComponent,
    MeasurementDetailsComponent,
    PaginationComponent,
    VendorsComponent,
    UomComponent,
    DepartmentComponent,
    LaborCostComponent,
    WarehouseComponent,
    PurchaseStatusComponent,
    StockAdjustmentComponent,
    OrderStatusComponent,
    TaskComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule, FontAwesomeModule
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
