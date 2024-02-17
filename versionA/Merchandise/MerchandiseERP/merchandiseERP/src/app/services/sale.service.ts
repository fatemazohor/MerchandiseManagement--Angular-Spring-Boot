import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Buyers, Department, LaborCost, MeasuremntDetails, OrderDetails, OrderStatus, PurchaseStatus, RawMaterialCat, Size, StockAdjustment, Style, StyleCategories, Task, Trim, UOM, Vendors, Warehouse } from '../model/sale.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SaleService {

  baseUrl = "http://localhost:8098/api/sale"

  constructor(private http: HttpClient) { }

  
  //------------------------------------------ Sale -------------------------------------------
  
  
  
  //Style Categories start
  getAllstyleCat(): Observable<StyleCategories[]> {
    return this.http.get<StyleCategories[]>(`${this.baseUrl}/style-categories`);
  }

  createstyleCat(scat: StyleCategories): Observable<StyleCategories> {
    return this.http.post<StyleCategories>(`${this.baseUrl}/style-categories`, scat)
  }

  updatestyleCat(id: number, scat: StyleCategories): Observable<StyleCategories> {
    return this.http.put<StyleCategories>(`${this.baseUrl}/style-categories/${id}`, scat);
  }

  deletestyleCat(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/style-categories/${id}`);
  }
  //Style Categories end
  //Size start

  getAllSize(): Observable<Size[]> {
    return this.http.get<Size[]>(`${this.baseUrl}/size`);
  }

  createSize(size: Size): Observable<Size> {
    return this.http.post<Size>(`${this.baseUrl}/size`, size)
  }

  updateSize(id: number, size: Size): Observable<Size> {
    return this.http.put<Size>(`${this.baseUrl}/size/${id}`, size);
  }

  deleteSize(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/size/${id}`);
  }

  //Size end
  //Trim start

  getAllTrim(): Observable<Trim[]> {
    return this.http.get<Trim[]>(`${this.baseUrl}/trim`);
  }

  createTrim(trim: Trim): Observable<Trim> {
    return this.http.post<Trim>(`${this.baseUrl}/trim`, trim)
  }

  updateTrim(id: number, trim: Trim): Observable<Trim> {
    return this.http.put<Trim>(`${this.baseUrl}/trim/${id}`, trim);
  }

  deleteTrim(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/trim/${id}`);
  }

  //Raw Material Categories start
  getAllRawMaterialCat(): Observable<RawMaterialCat[]> {
    return this.http.get<RawMaterialCat[]>(`${this.baseUrl}/raw_material_cate`);
  }

  createRawMaterialCat(materialCate: RawMaterialCat): Observable<RawMaterialCat> {
    return this.http.post<RawMaterialCat>(`${this.baseUrl}/raw_material_cate`, materialCate)
  }

  updateRawMaterialCat(id: number, materialCate: RawMaterialCat): Observable<RawMaterialCat> {
    return this.http.put<RawMaterialCat>(`${this.baseUrl}/raw_material_cate/${id}`, materialCate);
  }

  deleteRawMaterialCat(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/raw_material_cate/${id}`);
  }
  
  
  
  //------------------------------------ Sale -----------------------------------------------------
  //------------------------------------ Sale dependent ------------------------------------------
  
  
  
  //Style start
  getAllStyle(): Observable<Style[]> {
    return this.http.get<Style[]>(`${this.baseUrl}/style`);
  }

  createStyle(style: Style): Observable<Style> {
    return this.http.post<Style>(`${this.baseUrl}/style`, style)
  }

  updateStyle(id: number, style: Style): Observable<Style> {
    return this.http.put<Style>(`${this.baseUrl}/style/${id}`, style);
  }

  deleteStyle(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/style/${id}`);
  }

  //Measurement Details 
  getAllMeasurementDetails(): Observable<MeasuremntDetails[]> {
    return this.http.get<MeasuremntDetails[]>(`${this.baseUrl}/measurement_details`);
  }

  createMeasurementDetails(details: MeasuremntDetails): Observable<MeasuremntDetails> {
    return this.http.post<MeasuremntDetails>(`${this.baseUrl}/measurement_details`, details);
  }

  updateMeasurementDetails(id: number, details: MeasuremntDetails): Observable<MeasuremntDetails> {
    return this.http.put<MeasuremntDetails>(`${this.baseUrl}/measurement_details/${id}`, details)
  }

  deleteMeasurementDetails(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/measurement_details/${id}`)
  }
  //Measurement Attachment
  // api Raw Material end
  // api Raw Material Attachment start
  // api Style Attachment start
  // api Style Material Quantity start
  
  
  
  //---------------------------------------- Inventory Table-----------------------------------------
  
  
  
  // api Warehouse start
  getAllWarehouse(): Observable<Warehouse[]> {
    return this.http.get<Warehouse[]>(`${this.baseUrl}/warehouse`);
  }

  createWarehouse(warehouse: Warehouse): Observable<Warehouse> {
    return this.http.post<Warehouse>(`${this.baseUrl}/warehouse`, warehouse);
  }

  updateWarehouse(id: number, warehouse: Warehouse): Observable<Warehouse> {
    return this.http.put<Warehouse>(`${this.baseUrl}/warehouse/${id}`, warehouse)
  }

  deleteWarehouse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/warehouse/${id}`)
  }

  // api Purchase Status start
  getAllPurchaseStatus(): Observable<PurchaseStatus[]> {
    return this.http.get<PurchaseStatus[]>(`${this.baseUrl}/purchase_status`);
  }

  createPurchaseStatus(status: PurchaseStatus): Observable<PurchaseStatus> {
    return this.http.post<PurchaseStatus>(`${this.baseUrl}/purchase_status`, status);
  }

  updatePurchaseStatus(id: number, status: PurchaseStatus): Observable<PurchaseStatus> {
    return this.http.put<PurchaseStatus>(`${this.baseUrl}/purchase_status/${id}`, status)
  }

  deletePurchaseStatus(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/purchase_status/${id}`)
  }

  // api Stock Adjustment start

  getAllStockAdjustment(): Observable<StockAdjustment[]> {
    return this.http.get<StockAdjustment[]>(`${this.baseUrl}/stock_adjustment`);
  }

  createStockAdjustment(stockAdjust: StockAdjustment): Observable<StockAdjustment> {
    return this.http.post<StockAdjustment>(`${this.baseUrl}/stock_adjustment`, stockAdjust);
  }
  
  updateStockAdjustment(id: number, stockAdjust: StockAdjustment): Observable<StockAdjustment> {
    return this.http.put<StockAdjustment>(`${this.baseUrl}/stock_adjustment/${id}`, stockAdjust)
  }

  deleteStockAdjustment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/stock_adjustment/${id}`)
  }

  // api Adjustment Material start
  // api Purchase start
  // api Stock start
  
  
  
  //-------------------------------------- Other ---------------------------------------------------
  
  
  
  // api Vendors start
  getAllVendors(): Observable<Vendors[]> {
    return this.http.get<Vendors[]>(`${this.baseUrl}/vendors`);
  }

  createVendors(vendor: Vendors): Observable<Vendors> {
    return this.http.post<Vendors>(`${this.baseUrl}/vendors`, vendor);
  }

  updateVendors(id: number, vendor: Vendors): Observable<Vendors> {
    return this.http.put<Vendors>(`${this.baseUrl}/vendors/${id}`, vendor)
  }

  deleteVendors(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/vendors/${id}`)
  }
  // api Vendors end
  // api Unit of Measurement start

  getAllUOM(): Observable<UOM[]> {
    return this.http.get<UOM[]>(`${this.baseUrl}/uom`);
  }

  createUOM(uom: UOM): Observable<UOM> {
    return this.http.post<UOM>(`${this.baseUrl}/uom`, uom);
  }

  updateUOM(id: number, uom: UOM): Observable<UOM> {
    return this.http.put<UOM>(`${this.baseUrl}/uom/${id}`, uom)
  }

  deleteUOM(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/uom/${id}`)
  }

  // api Unit of Measurement end
  
  
  
  //---------------------------------------- BOM Table----------------------------------------------
  
  
  
  // api Department start

  getAllDepartment(): Observable<Department[]> {
    return this.http.get<Department[]>(`${this.baseUrl}/department`);
  }

  createDepartment(dept: Department): Observable<Department> {
    return this.http.post<Department>(`${this.baseUrl}/department`, dept);
  }

  updateDepartment(id: number, dept: Department): Observable<Department> {
    return this.http.put<Department>(`${this.baseUrl}/department/${id}`, dept)
  }

  deleteDepartment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/department/${id}`)
  }

  // api Department end
  // api Labor Cost start
  getAllLaborCost(): Observable<LaborCost[]> {
    return this.http.get<LaborCost[]>(`${this.baseUrl}/labor_cost`);
  }

  createLaborCost(cost: LaborCost): Observable<LaborCost> {
    return this.http.post<LaborCost>(`${this.baseUrl}/labor_cost`, cost);
  }

  updateLaborCost(id: number, cost: LaborCost): Observable<LaborCost> {
    return this.http.put<LaborCost>(`${this.baseUrl}/labor_cost/${id}`, cost)
  }

  deleteLaborCost(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/labor_cost/${id}`)
  }
  // api Labor Cost end
  
  
  
  //---------------------------------------- Buyers Table--------------------------------------------



  // api Buyers start
  getAllBuyers(): Observable<Buyers[]> {
    return this.http.get<Buyers[]>(`${this.baseUrl}/buyers`);
  }

  createBuyers(buyer: Buyers): Observable<Buyers> {
    return this.http.post<Buyers>(`${this.baseUrl}/buyers`, buyer);
  }

  updateBuyers(id: number, buyer: Buyers): Observable<Buyers> {
    return this.http.put<Buyers>(`${this.baseUrl}/buyers/${id}`, buyer)
  }

  deleteBuyers(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/buyers/${id}`)
  }
  // api Task start

  getAllTask(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.baseUrl}/task`);
  }

  createTask(task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.baseUrl}/task`, task);
  }

  updateTask(id: number, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.baseUrl}/task/${id}`, task)
  }

  deleteTask(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/task/${id}`)
  }
  
  // api Orders Status start
  getAllOrdersStatus(): Observable<OrderStatus[]> {
    return this.http.get<OrderStatus[]>(`${this.baseUrl}/order_status`);
  }

  createOrdersStatus(orderStatus: OrderStatus): Observable<OrderStatus> {
    return this.http.post<OrderStatus>(`${this.baseUrl}/order_status`, orderStatus);
  }

  updateOrdersStatus(id: number, orderStatus: OrderStatus): Observable<OrderStatus> {
    return this.http.put<OrderStatus>(`${this.baseUrl}/order_status/${id}`, orderStatus)
  }

  deleteOrdersStatus(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/order_status/${id}`)
  }
  // api Orders start

  getAllOrdersDetails(): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(`${this.baseUrl}/orders`);
  }

  createOrdersDetails(order: OrderDetails): Observable<OrderDetails> {
    return this.http.post<OrderDetails>(`${this.baseUrl}/orders`, order);
  }

  updateOrdersDetails(id: number, order: OrderDetails): Observable<OrderDetails> {
    return this.http.put<OrderDetails>(`${this.baseUrl}/orders/${id}`, order)
  }

  deleteOrdersDetails(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/orders/${id}`)
  }

  // api Time Action start
  //---------------------------------------- Report Table----------------------------------

}
