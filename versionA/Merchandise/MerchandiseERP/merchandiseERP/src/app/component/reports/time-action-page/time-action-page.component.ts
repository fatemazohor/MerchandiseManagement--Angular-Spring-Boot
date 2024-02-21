import { Component, OnInit } from '@angular/core';
import { OrderDetails, TimeAction } from '../../../model/sale.model';
import { SaleService } from '../../../services/sale.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-time-action-page',
  templateUrl: './time-action-page.component.html',
  styleUrl: './time-action-page.component.css'
})
export class TimeActionPageComponent implements OnInit{

  order:OrderDetails=new OrderDetails()
  actionList:TimeAction[]=[]
  orderId:any
  constructor(
    private service:SaleService,
    private routeA:ActivatedRoute
  ){}
  ngOnInit(): void {
    this.routeA.params.subscribe(param=> this.orderId = param['id'])
    console.log(this.orderId)
    this.loadOrderbyId(this.orderId)
    this.loadTNAbyOrderId(this.orderId)
    
  }

  //time action list
   loadTNAbyOrderId(Id:number){
    this.service.getTimeActionByOrderId(Id).subscribe({
      next: res => {
        this.actionList = res
      },
      error: err => {
        console.log(err);
      }
    })
  }


   //style find by id
   loadOrderbyId(orderId:number){
    this.service.getOrderDetailsById(orderId).subscribe({
      next: res => {
        this.order = res
      },
      error: err => {
        console.log(err);
      }
    })
  }







}
