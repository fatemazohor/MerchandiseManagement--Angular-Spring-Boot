import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { faPenToSquare, faTrash } from '@fortawesome/free-solid-svg-icons';
import { SaleService } from '../../../services/sale.service';
import { Style, StyleCategories } from '../../../model/sale.model';


@Component({
  selector: 'app-style',
  templateUrl: './style.component.html',
  styleUrl: './style.component.css'
})
export class StyleComponent implements OnInit{

  style:Style[]=[]
  category:StyleCategories[]=[]
  styleForm!:FormGroup
  styleModel:Style=new Style();
  title:string="style list";
  //font awesome icon list
  fatrash=faTrash;
  editicon=faPenToSquare

  constructor(
    private saleService:SaleService,
    private formBuilder:FormBuilder,
   
  ){}

  ngOnInit(): void {
    this.loadstyle();
    this.initstyleForm();
    this.loadCategories();
  }

  initstyleForm(){
    this.styleForm=this.formBuilder.group({
      code:['',Validators.required],
      description:['',Validators.required],
      categoriesId:['',Validators.required]
    })
  }

  //all style list
  private loadstyle(){
    this.saleService.getAllStyle().subscribe({
      next:res=>{
        this.style=res
      },
      error:err=>{
        console.log(err);
      }
    })
  }
  //all style categories list
  private loadCategories(){
    this.saleService.getAllstyleCat().subscribe({
      next:res=>{
        this.category=res
      },
      error:err=>{
        console.log(err);
      }
    })
  }

  //delete a style
  deletestyle(styleId:number){
    this.saleService.deleteStyle(styleId).subscribe({
      next:res=>{
        console.log("style deleted",res)
        alert("style deleted.")
        this.loadstyle();
        //after delete page reload to dashboard .fix it to list page.
         
      },
      error:er=>{
        console.log(er)
        alert("Data not deleted")
      }
    })
  }
// ??????categories save update not working????
  // create new style
  onSubmit(){
    if(this.styleForm.valid){
      const styleData:Style =this.styleForm.value;
      this.saleService.createStyle(styleData).subscribe({
        next:res=>{
          console.log("style saved",res)
          alert("style saved.")
          this.loadstyle();
          this.styleForm.reset();
        },
        error:er=>{
          console.log(er)
          alert("Data not saved")
        }
      })
    }
  }

  // set data on form to update
  onEditById(styleRow:any){
    this.styleModel.id=styleRow.id;
    this.styleForm.controls['code'].setValue(styleRow.code)
    this.styleForm.controls['description'].setValue(styleRow.description)
    this.styleForm.controls['categoriesId'].setValue(styleRow.categoriesId.name)
  }
  //update style name
 editstyle(){
    if(this.styleForm.valid){
      this.styleModel.code=this.styleForm.value.code
      this.styleModel.description=this.styleForm.value.description
      this.styleModel.categoriesId=this.styleForm.value.categoriesId
      this.saleService.updatestyleCat(this.styleModel.id,this.styleModel).subscribe({
        next:res=>{
          console.log("style updated",res)
          alert("style updated.")
          this.loadstyle();
          this.styleForm.reset();
        },
        error:er=>{
          console.log(er)
          alert("Data not updated")
        }
      })
    }
  }



}