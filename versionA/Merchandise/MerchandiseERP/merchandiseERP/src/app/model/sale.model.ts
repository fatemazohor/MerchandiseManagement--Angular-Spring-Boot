//---------------------------------------- Sale ---------------------------------------------

import exp from "constants";

    //style Categories start
export class StyleCategories{
    id:number=0
    name?:string;
}
//style Categories end
    //Size start
export class Size{
    id:number=0
    name?:string;
}
//Size end
    //Trim start
export class Trim{
    id:number=0
    name?:string;
}
    //Fabric start (optional)
export class Fabric{
    id:number=0
    name?:string;
    description?:string;
}
    //Raw Material Categories start
export class RawMaterialCat{
    id:number=0
    name?:string;
}
//-------------------------------------- Sale dependent -----------------------------------
    // Style start
export class Style{
    id:number=0
    code?:string;
    description?:string;
    categoriesId?: {
        id:number,
        name?: string
      }
}
    //Measuremant Details
export class MeasuremntDetails{
    
        id:number=0
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
    //
//-------------------------------------- Inventory ----------------------------------------
//-------------------------------------- Other --------------------------------------------
//-------------------------------------- Report -------------------------------------------