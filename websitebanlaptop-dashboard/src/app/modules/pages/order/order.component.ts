import { OrderDetailDialogComponent } from './../../../core/components/order-detail-dialog/order-detail-dialog.component';
import { OrderModel } from './../../../core/models/order.model';
import { Component, OnInit } from '@angular/core';
import { VariablesConstant } from 'src/app/core/constants/variables.constant';
import { NotificationService } from 'src/app/shared/services/notification.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog, PageEvent } from '@angular/material';
import { OrderService } from 'src/app/core/services/order/order.service';
import { ResponseModel } from 'src/app/core/models/response.model';
import { Pageable } from 'src/app/core/models/pageable.model';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
// list orders
listOrders: OrderModel[] = [];
// total items
totalItems: number;
// page size of table
pageSize = VariablesConstant.PAGE_SIZE;
// page number of table
pageNumber = VariablesConstant.PAGE_NUMBER;
  constructor(
    private _orderService: OrderService,
    private _notificationService: NotificationService,
    private _route: ActivatedRoute,
    private _router: Router,
    private _dialog: MatDialog
  ) { }

  ngOnInit() {
    this._route.queryParams
      .subscribe((params) => {
        if (params.size) {
          this.pageSize = params.size;
        }
        if (params.page) {
          this.pageNumber = params.page;
        }
        this.getPageableOrders(this.pageSize, this.pageNumber);
      });
  }

  getPageableOrders(pageSize: number, pageNumber: number) {
    this._orderService.getPagebleOrders(pageSize, pageNumber)
      .subscribe((res: ResponseModel<Pageable<OrderModel>>) => {
        if (res.code === 200) {
          this.listOrders = res.data.content;
          this.totalItems = res.data.totalElements
        }
      });
  }

  viewOrderDetail(order: OrderModel) {
    const dialogRef = this._dialog.open(OrderDetailDialogComponent, {
      width: '800px',
      data: {
        id: order.orderId
      }
    });
    dialogRef.afterClosed()
      .subscribe(data => {

      });
  }

  pageSizeChange($event: PageEvent) {
    return this._router.navigateByUrl(`/order?size=${$event.pageSize}&page=${$event.pageIndex}`);
  }

}
