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
//-------------------------------------- Sale dependent -----------------------------------
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
//---------------------------------------- Inventory Table-------------------------------
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
//  Adjustment Material start
//  Purchase start
//  Stock start
//---------------------------------------- Other --------------------------------------------
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
//---------------------------------------- BOM Table----------------------------------
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

//---------------------------------------- Buyers Table----------------------------------
//  Buyers start
//  Task start
//  Orders Status start
//  Orders start
//  Time Action start
//---------------------------------------- Report Table----------------------------------