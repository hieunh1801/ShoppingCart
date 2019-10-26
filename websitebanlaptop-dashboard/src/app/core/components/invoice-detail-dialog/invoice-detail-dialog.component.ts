import { InvoiceDetailResponseModel } from './../../models/invoice-detail-response.model';
import { ResponseModel } from 'src/app/core/models/response.model';
import { InvoiceService } from './../../services/invoice/invoice.service';
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-invoice-detail-dialog',
  templateUrl: './invoice-detail-dialog.component.html',
  styleUrls: ['./invoice-detail-dialog.component.scss']
})
export class InvoiceDetailDialogComponent implements OnInit {
  invoiceDetail: InvoiceDetailResponseModel;

  constructor(public dialogRef: MatDialogRef<InvoiceDetailDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _formBuilder: FormBuilder,
    private _invoiceService: InvoiceService
  ) { }

  ngOnInit() {
    if (this.data.id) {
      this.getInvoiceDetailById(this.data.id);
    }
  }

  getInvoiceDetailById(id: any) {
    this._invoiceService.getInvoiceDetailById(this.data.id)
      .subscribe((res: ResponseModel<InvoiceDetailResponseModel>) => {
        if (res.code === 200) {
          this.invoiceDetail = res.data;
        }
      });
  }

  cancel() {
    this.dialogRef.close(null);
  }

}
