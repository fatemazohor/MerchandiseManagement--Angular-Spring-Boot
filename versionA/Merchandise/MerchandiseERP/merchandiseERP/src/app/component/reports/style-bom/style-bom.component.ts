import { Component, OnInit } from '@angular/core';
import { LaborCost, Style, StyleAttachment, StyleMaterialQty } from '../../../model/sale.model';
import { SaleService } from '../../../services/sale.service';



@Component({
  selector: 'app-style-bom',
  templateUrl: './style-bom.component.html',
  styleUrl: './style-bom.component.css'
})
export class StyleBomComponent implements OnInit {

  style: Style[] = []
  imageList: StyleAttachment[] = []
  cost: LaborCost[] = []
  smallQty: StyleMaterialQty[] = []
  midQty: StyleMaterialQty[] = []
  largeQty: StyleMaterialQty[] = []
  //style variable for single object
  styleData: Style = new Style();
  title: string = "Style BOM list";
  menutype: boolean = true;
  showData: string = 'when true'
  constructor(
    private service: SaleService,

  ) { }
  ngOnInit(): void {
    this.loadstyle();
  }

  //all style list
  private loadstyle() {
    this.service.getAllStyle().subscribe({
      next: res => {
        this.style = res
      },
      error: err => {
        console.log(err);
      }
    })
  }
  //style attachment list
  loadstyleAttachment() {
    this.service.getAllStyle().subscribe({
      next: res => {
        this.imageList = res
      },
      error: err => {
        console.log(err);
      }
    })
  }
  //labor cost list
  loadLaborCost(id: number) {
    this.service.getLaborCostByStyleId(id).subscribe({
      next: res => {
        this.cost = res
      },
      error: err => {
        console.log(err);
      }
    })
  }
  //attachment list
  loadAttachment(id: number) {
    this.service.getAttachmentByStyleId(id).subscribe({
      next: res => {
        this.imageList = res
      },
      error: err => {
        console.log(err);
      }
    })
  }
  //small Material Qty list
  loadsmallMaterialQty(id: number) {
    this.service.getstyleMatByStyleId(id,3).subscribe({
      next: res => {
        this.smallQty = res
        this.calculateTotal('totalprice','smallTable',4,5)
        
      },
      error: err => {
        console.log(err);
      }
    })
  }
  //medium Material Qty list
  loadmidMaterialQty(id: number) {
    this.service.getstyleMatByStyleId(id,2).subscribe({
      next: res => {
        this.midQty = res
        
      },
      error: err => {
        console.log(err);
      }
    })
  }
  //large Material Qty list
  loadLargeMaterialQty(id: number) {
    this.service.getstyleMatByStyleId(id,1).subscribe({
      next: res => {
        this.largeQty = res
        
      },
      error: err => {
        console.log(err);
      }
    })
  }
  

  //style by id
  findStyleById(styleId: number) {
    this.service.getStyleById(styleId).subscribe({
      next: res => {
        this.styleData = res
        this.loadLaborCost(styleId)
        this.loadAttachment(styleId)
        this.loadsmallMaterialQty(styleId)
        this.loadmidMaterialQty(styleId)
        this.loadLargeMaterialQty(styleId)
        this.showBom();
      },
      error: err => {
        console.log(err);
      }
    })
  }

  showBom() {

    this.menutype = false;
    this.showData = 'when FALSE'

  }
  showBomList(id: number) {
    this.loadLaborCost(id);
    this.findStyleById(id)
    if (this.cost && this.styleData != null) {
      this.menutype = false;
      this.showData = 'when FALSE'
    }
  }
  gettotalPrice(hour:number,price:number):number{
    return hour * price;
  }

  reset() {
    this.menutype = true;
    this.showData = 'when true'

    this.styleData = new Style();
  }

  calculateTotal(tdName: string, myTable: string, qcell: number, ucell: number): void {
    const table = document.getElementById(myTable) as HTMLTableElement;
    let totalCost = 0;

    for (let i = 1; i < table.rows.length; i++) {
      const quantityCell = table.rows[i].cells[qcell];
      const unitPriceCell = table.rows[i].cells[ucell];

      if (quantityCell && unitPriceCell) {
        const quantity = parseFloat(quantityCell.textContent!.trim()) || 0;
        const unitPrice = parseFloat(unitPriceCell.textContent!.trim()) || 0;

        totalCost += quantity * unitPrice;
      }
    }

    document.getElementById(tdName)!.innerHTML = totalCost.toFixed(1);
  }

}
