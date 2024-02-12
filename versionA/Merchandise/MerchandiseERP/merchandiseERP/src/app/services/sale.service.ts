import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MeasuremntDetails, RawMaterialCat, Size, Style, StyleCategories, Trim } from '../model/sale.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SaleService {

  baseUrl="http://localhost:8098/api/sale"

  constructor(private http:HttpClient) { }

//------------------------------------------ Sale -------------------------------------------
  //Style Categories start
  getAllstyleCat():Observable<StyleCategories[]>{
    return this.http.get<StyleCategories[]>(`${this.baseUrl}/style-categories`);
  }

  createstyleCat(scat:StyleCategories):Observable<StyleCategories>{
    return this.http.post<StyleCategories>(`${this.baseUrl}/style-categories`,scat)
  }

  updatestyleCat(id:number,scat:StyleCategories):Observable<StyleCategories>{
    return this.http.put<StyleCategories>(`${this.baseUrl}/style-categories/${id}`,scat);
  }

  deletestyleCat(id:number):Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/style-categories/${id}`);
  }
  //Style Categories end
  //Size start

  getAllSize():Observable<Size[]>{
    return this.http.get<Size[]>(`${this.baseUrl}/size`);
  }

  createSize(size:Size):Observable<Size>{
    return this.http.post<Size>(`${this.baseUrl}/size`,size)
  }

  updateSize(id:number,size:Size):Observable<Size>{
    return this.http.put<Size>(`${this.baseUrl}/size/${id}`,size);
  }

  deleteSize(id:number):Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/size/${id}`);
  }

  //Size end
  //Trim start

 getAllTrim():Observable<Trim[]>{
    return this.http.get<Trim[]>(`${this.baseUrl}/trim`);
  }

  createTrim(trim:Trim):Observable<Trim>{
    return this.http.post<Trim>(`${this.baseUrl}/trim`,trim)
  }

  updateTrim(id:number,trim:Trim):Observable<Trim>{
    return this.http.put<Trim>(`${this.baseUrl}/trim/${id}`,trim);
  }

  deleteTrim(id:number):Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/trim/${id}`);
  }
  
  //Raw Material Categories start
  getAllRawMaterialCat():Observable<RawMaterialCat[]>{
    return this.http.get<RawMaterialCat[]>(`${this.baseUrl}/raw_material_cate`);
  }

  createRawMaterialCat(materialCate:RawMaterialCat):Observable<RawMaterialCat>{
    return this.http.post<RawMaterialCat>(`${this.baseUrl}/raw_material_cate`,materialCate)
  }

  updateRawMaterialCat(id:number,materialCate:RawMaterialCat):Observable<RawMaterialCat>{
    return this.http.put<RawMaterialCat>(`${this.baseUrl}/raw_material_cate/${id}`,materialCate);
  }

  deleteRawMaterialCat(id:number):Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/raw_material_cate/${id}`);
  }
  //------------------------------------ Sale ---------------------------------------------
  //------------------------------------ Sale dependent -----------------------------------
  //Style start
  getAllStyle():Observable<Style[]>{
    return this.http.get<Style[]>(`${this.baseUrl}/style`);
  }

  createStyle(style:Style):Observable<Style>{
    return this.http.post<Style>(`${this.baseUrl}/style`,style)
  }

  updateStyle(id:number,style:Style):Observable<Style>{
    return this.http.put<Style>(`${this.baseUrl}/style/${id}`,style);
  }

  deleteStyle(id:number):Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/style/${id}`);
  }
  
  //Measurement Details 
  getAllMeasurementDetails():Observable<MeasuremntDetails[]>{
    return this.http.get<MeasuremntDetails[]>(`${this.baseUrl}/measurement_details`);
  }

  createMeasurementDetails(details:MeasuremntDetails):Observable<MeasuremntDetails>{
    return this.http.post<MeasuremntDetails>(`${this.baseUrl}/measurement_details`,details);
  }

  updateMeasurementDetails(id:number,details:MeasuremntDetails):Observable<MeasuremntDetails>{
    return this.http.put<MeasuremntDetails>(`${this.baseUrl}/measurement_details/${id}`,details)
  }

  deleteMeasurementDetails(id:number):Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/measurement_details/${id}`)
  }
  //Measurement Attachment
  
//-------------------------------------- Inventory ----------------------------------------
//-------------------------------------- Other --------------------------------------------
//-------------------------------------- Report -------------------------------------------

}
