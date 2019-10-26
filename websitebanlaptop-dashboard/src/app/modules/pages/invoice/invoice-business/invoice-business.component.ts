import { NotificationService } from './../../../../shared/services/notification.service';
import { InvoiceService } from './../../../../core/services/invoice/invoice.service';
import { ProductModel } from './../../../../core/models/product.model';
import { ResponseModel } from './../../../../core/models/response.model';
import { SupplierModel } from './../../../../core/models/supplier.model';
import { ProductService } from './../../../../core/services/product/product.service';
import { SupplierService } from '../../../../core/services/supplier/supplier.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-invoice-business',
  templateUrl: './invoice-business.component.html',
  styleUrls: ['./invoice-business.component.scss']
})
export class InvoiceBusinessComponent implements OnInit {
  suppliers: SupplierModel[];

  products: ProductModel[];

  containers = [];

  supplierId: number;

  notes: string;

  constructor(
    private _supplierService: SupplierService,
    private _productService: ProductService,
    private _invoiceService: InvoiceService,
    private _notificationService: NotificationService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  ngOnInit() {
    this.getAllSuppliers();
    this.getAllProducts();
  }

  getAllProducts() {
    this._productService.getAllProducts()
      .subscribe((res: ResponseModel<ProductModel[]>) => {
        if (res.code === 200) {
          this.products = res.data;
        }
      });
  }

  getAllSuppliers() {
    this._supplierService.getAllSuppliers()
      .subscribe((res: ResponseModel<SupplierModel[]>) => {
        if (res.code === 200) {
          this.suppliers = res.data;
        }
      });
  }

  addInvoice() {
    this.containers.push(this.containers.length);
  }

  submitInvoice() {
    let listInvoiceDetails = [];
    this.containers.forEach(el => {
      const price = parseFloat((<HTMLInputElement>document.getElementsByClassName(`price-${el}`)[0]).value);
      const amount = parseInt((<HTMLInputElement>document.getElementsByClassName(`amount-${el}`)[0]).value);
      const laptopId = parseInt((<HTMLInputElement>document.getElementsByClassName(`product-${el}`)[0]).value);
      
      const invoiceDetail = {
        laptopId,
        price,
        amount
      }
      listInvoiceDetails.push(invoiceDetail);
    });
    
    const data = {
      supplierId: this.supplierId,
      notes: this.notes,
      listInvoiceDetails
    }
    
    this._invoiceService.createInvocie(data)
      .subscribe((res: ResponseModel<number>) => {
        if (res.code === 200) {
          this._notificationService.showSuccess('Thêm hoá đơn thành công', res.message, 3000);
          this._router.navigateByUrl('/invoice');
        }
      });
  }

}
