import { OrderService } from './../../services/order/order.service';
import { OrderModel } from './../../models/order.model';
import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { ResponseModel } from '../../models/response.model';

@Component({
  selector: 'app-order-detail-dialog',
  templateUrl: './order-detail-dialog.component.html',
  styleUrls: ['./order-detail-dialog.component.scss']
})
export class OrderDetailDialogComponent implements OnInit {
  order: OrderModel;
  constructor(public dialogRef: MatDialogRef<OrderDetailDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _orderService: OrderService) { }

  ngOnInit() {
    if (this.data.id) {
      this.getOrderDetailById(this.data.id);
    }
  }

  getOrderDetailById(id: any) {
    this._orderService.getOrderDetailById(id)
      .subscribe((res: ResponseModel<OrderModel>) => {
        if (res.code === 200) {
          this.order = res.data;
        }
      });
  }

  cancel() {
    this.dialogRef.close(null);
  }

}
