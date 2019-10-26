import { Pageable } from './../../../core/models/pageable.model';
import { ResponseModel } from './../../../core/models/response.model';
import { InvoiceModel } from './../../../core/models/invoice.model';
import { NotificationService } from './../../../shared/services/notification.service';
import { InvoiceService } from './../../../core/services/invoice/invoice.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VariablesConstant } from 'src/app/core/constants/variables.constant';
import { PageEvent, MatDialog } from '@angular/material';
import { InvoiceDetailDialogComponent } from 'src/app/core/components/invoice-detail-dialog/invoice-detail-dialog.component';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.scss']
})
export class InvoiceComponent implements OnInit {
  // list invoices
  listInvoices: InvoiceModel[] = [];
  // total items
  totalItems: number;
  // page size of table
  pageSize = VariablesConstant.PAGE_SIZE;
  // page number of table
  pageNumber = VariablesConstant.PAGE_NUMBER;
  constructor(
    private _invoiceService: InvoiceService,
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
        this.getPageableInvoices(this.pageSize, this.pageNumber);
      });
  }

  getPageableInvoices(pageSize: number, pageNumber: number) {
    this._invoiceService.getPagebleInvoices(pageSize, pageNumber)
      .subscribe((res: ResponseModel<Pageable<InvoiceModel>>) => {
        if (res.code === 200) {
          this.listInvoices = res.data.content;
          this.totalItems = res.data.totalElements
        }
      });
  }

  viewInvoiceDetail(invoice: InvoiceModel) {
    const dialogRef = this._dialog.open(InvoiceDetailDialogComponent, {
      width: '800px',
      data: {
        id: invoice.invoiceId
      }
    });
    dialogRef.afterClosed()
      .subscribe(data => {

      });
  }

  pageSizeChange($event: PageEvent) {
    return this._router.navigateByUrl(`/invoice?size=${$event.pageSize}&page=${$event.pageIndex}`);
  }
}
