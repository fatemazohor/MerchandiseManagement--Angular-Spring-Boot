//---------------------------------------- Sale ---------------------------------------------

import exp from "constants";

//style Categories start
export class StyleCategories {
  id: number = 0
  name?: string;
}
//style Categories end
//Size start
export class Size {
  id: number = 0
  name?: string;
}
//Size end
//Trim start
export class Trim {
  id: number = 0
  name?: string;
}
//Fabric start (optional)
export class Fabric {
  id: number = 0
  name?: string;
  description?: string;
}
//Raw Material Categories start
export class RawMaterialCat {
  id: number = 0
  name?: string;
}



//-------------------------------------- Sale dependent --------------------------------------



// Style start
export class Style {
  id: number = 0
  code?: string;
  description?: string;
  categoriesId?: {
    id: number,
    name?: string
  }
}
//Measuremant Details
export class MeasuremntDetails {

  id: number = 0
  description?: string;
  tolerance?: string;
  small?: string;
  medium?: string;
  large?: string
  styleId?: {
    id: number,
    code?: string,
    description?: string,
    categoriesId?: {
      id: number,
      name?: string
    }
  }
}

// Raw Material end
//  Raw Material Attachment start
//  Style Attachment start
//  Style Material Quantity start



//---------------------------------------- Inventory Table--------------------------------------



//  Warehouse start
export class Warehouse{
  id:number = 0 
  name?: string
  city?: string
  contact?: string
}
//  Purchase Status start
export class PurchaseStatus{
  id:number= 0
  name?: string
}
//  Stock Adjustment start
export class StockAdjustment{
  id:number= 0
  name?: string
  factor?:number
}
//  Adjustment Material start
//  Purchase start
//  Stock start



//---------------------------------------- Other ------------------------------------------------



//  Vendors start
export class Vendors {
  id: number = 0;
  company?: string;
  contactPerson?: string;
  cell?: string;
  email?: string;
  address?: string;
}
//  Unit of Measurement start
export class UOM {
  id: number = 0;
  name?: string;
}



//---------------------------------------- BOM Table-----------------------------------------------



//  Department start
export class Department {
  id: number = 0;
  name?: string;
}
//  Labor Cost start
export class LaborCost {
  id: number = 0
  unitCost?: number
  hour?: number
  styleId?:{
    id: number
    code?: string
    description?: string
    categoriesId?:{
      id: number
      name?: string
    }
  }
  departmentId?:{
    id: number,
    name?: string
  }
}



//---------------------------------------- Buyers Table ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



//  Buyers start
export class Buyers{
  id:number= 0
  organization?: string
  contactPerson?: string
  phone?: string
  email?: string
  address?: string
  country?: string
}
//  Task start
export class Task{
  id:number= 0
  name?: string
}
//  Orders Status start
export class OrderStatus{
  id:number= 0
  name?: string
}
//  Orders start
export class OrderDetails{
    id:number= 0
    oderDate?: Date
    deliveryDate?: Date
    shippingAddress?: string
    orderUniId?: string
    totalAmount?:number
    paid?:number
    sAmount?: number
    mAmount?: number
    lAmount?: number
    styleId?: {
      id:number
      code?: string
      description?:string
      categoriesId?: {
        id: number
        name?: string
      }
      createdAt?: Date
      updatedAt?: Date
    }
    buyersId?: {
      id:number
      organization?: string
      contactPerson?: string
      phone?: string
      email?: string
      address?: string
      country?: string
    }
    orStatusId?: {
      id:number
      name?: string
    }
    
  }

//  Time Action start



//---------------------------------------- Report Table----------------------------------