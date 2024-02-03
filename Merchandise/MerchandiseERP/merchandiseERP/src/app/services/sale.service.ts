import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Size, StyleCategories } from '../model/sale.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  baseUrl="http://localhost:8098/api/sale"

  constructor(private http:HttpClient) { }


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

}
