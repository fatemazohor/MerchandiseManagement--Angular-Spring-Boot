import { Component, OnInit } from '@angular/core';
import { Buyers, OrderDetails, OrderStatus, Style } from '../../../model/sale.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { faPenToSquare, faTrash } from '@fortawesome/free-solid-svg-icons';
import { SaleService } from '../../../services/sale.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent implements OnInit{

  order:OrderDetails[]=[]
  buyer:Buyers[]=[]
  status: OrderStatus[] = []
  style:Style[]=[]
  orderForm!:FormGroup
  orderModel:OrderDetails=new OrderDetails();
  title:string="Order Details List";
  title2:string="Order Details Entry Form";
  menuType: boolean=true;
  //font awesome icon list
  fatrash=faTrash;
  editicon=faPenToSquare
  //calculation
  smallQuantity?:number=0;
  mediumQuantity?:number=0;
  largeQuantity?:number=0;
  subTotal?:number=0;
  vat?:number=0;
 
  paid?:number=0;
  due?:number=0;
  total?:number=0;
  
  constructor(
    private service:SaleService,
    private formBuilder:FormBuilder
  ){}
  ngOnInit(): void {
    this.initOrdersForm()
    this.loadOrder()
    this.loadBuyers()
    this.loadOrderStatus()
    this.loadstyle()
  }

  initOrdersForm() {
    this.orderForm = this.formBuilder.group({
      oderDate: ['', Validators.required],
      deliveryDate: ['', Validators.required],
      shippingAddress: ['', Validators.required],
      
      totalAmount: ['', Validators.required],
      paid: ['', Validators.required],
      sAmount: ['', Validators.required],
      mAmount: ['', Validators.required],
      lAmount: ['', Validators.required],
      orStatusId: ['', Validators.required],
      buyersId: ['', Validators.required],
      styleId: ['', Validators.required]

    })
  }

  //all style list
  private loadstyle(){
    this.service.getAllStyle().subscribe({
      next:res=>{
        this.style=res
      },
      error:err=>{
        console.log(err);
      }
    })
  }

  //all Order Status list
  private loadOrderStatus() {
    this.service.getAllOrdersStatus().subscribe({
      next: res => {
        this.status = res;
      },
      error: err => {
        console.log(err);
      }
    })
  }

  //all buyers list
  private loadBuyers() {
    this.service.getAllBuyers().subscribe({
      next: res => {
        this.buyer = res;
      },
      error: err => {
        console.log(err);
      }
    })
  }

  //all orders list
  private loadOrder() {
    this.service.getAllOrdersDetails().subscribe({
      next: res => {
        this.order = res;
      },
      error: err => {
        console.log(err);
      }
    })
  }

  //delete a Order
  deleteOrder(orderId: number) {
    this.service.deleteOrdersDetails(orderId).subscribe({
      next: res => {
        console.log("Orders Details deleted", res)
        alert("Orders Details deleted.")
        this.loadOrder();

      },
      error: er => {
        console.log(er)
        alert("Data not deleted")
      }
    })
  }

  // create new order
  onSubmit() {
    if (this.orderForm.valid) {

      const orderData: OrderDetails = this.orderForm.value;
      this.service.createOrdersDetails(orderData).subscribe({
        next: res => {
          console.log("Orders Details saved", res)
          alert("Orders Details saved.")
          this.loadOrder();
          this.orderForm.reset();
        },
        error: er => {
          console.log(er)
          alert("Data not saved")
        }
      })
    }
  }

  // set data on form to update
  onEditById(orderRow: any) {
    this.menuType = false;
    this.orderModel.id = orderRow.id;
    this.orderForm.controls['oderDate'].setValue(orderRow.oderDate)
    this.orderForm.controls['deliveryDate'].setValue(orderRow.deliveryDate)
    this.orderForm.controls['shippingAddress'].setValue(orderRow.shippingAddress)
    this.orderForm.controls['sAmount'].setValue(orderRow.sAmount)
    this.orderForm.controls['lAmount'].setValue(orderRow.lAmount)
    this.orderForm.controls['mAmount'].setValue(orderRow.mAmount)
    this.orderForm.controls['orStatusId'].setValue(orderRow.orStatusId.name)
    this.orderForm.controls['buyersId'].setValue(orderRow.buyerId.organization)
    this.orderForm.controls['styleId'].setValue(orderRow.styleId.code)
    this.orderForm.controls['totalAmount'].setValue(orderRow.totalAmount)
    this.orderForm.controls['paid'].setValue(orderRow.paid)
    
  }

  //update Orders Details data
  editOrdersDetails() {
    if (this.orderForm.valid) {

      this.orderModel.oderDate = this.orderForm.value.orderData
      this.orderModel.deliveryDate = this.orderForm.value.deliveryDate
      this.orderModel.shippingAddress = this.orderForm.value.shippingAddress
      this.orderModel.sAmount = this.orderForm.value.sAmount
      this.orderModel.lAmount = this.orderForm.value.lAmount
      this.orderModel.mAmount = this.orderForm.value.mAmount
      this.orderModel.orStatusId = this.orderForm.value.orStatusId
      this.orderModel.buyersId = this.orderForm.value.buyerId
      this.orderModel.styleId = this.orderForm.value.styleId
      this.orderModel.totalAmount = this.orderForm.value.tolerance
      this.orderModel.paid = this.orderForm.value.paid

      this.service.updateOrdersDetails(this.orderModel.id, this.orderModel).subscribe({
        next: res => {

          console.log("Orders Details updated", res)
          alert("Orders Details updated.")
          this.loadOrder();
          this.orderForm.reset();
          // console.log("inside vendor update")
        },
        error: er => {
          console.log(er)
          alert("Data not updated")
        }
      })
    }
  }

  emptybox(){}
  totalbox(){}

}
