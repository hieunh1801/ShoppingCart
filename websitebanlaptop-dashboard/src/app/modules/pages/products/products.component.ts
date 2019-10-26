import { NotificationService } from './../../../shared/services/notification.service';

import { Pageable } from './../../../core/models/pageable.model';
import { CodeConstant } from './../../../core/constants/code.constant';
import { ResponseModel } from 'src/app/core/models/response.model';
import { VariablesConstant } from 'src/app/core/constants/variables.constant';
import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/core/services/product/product.service';
import { ProductModel } from 'src/app/core/models/product.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PageEvent } from '@angular/material';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  listProducts: ProductModel[] = [];
  totalItems: number;
  // page size of table
  pageSize = VariablesConstant.PAGE_SIZE;
  // page number of table
  pageNumber = VariablesConstant.PAGE_NUMBER;
  constructor(
    private _productService: ProductService,
    private _notificationService: NotificationService,
    private _route: ActivatedRoute,
    private _router: Router,
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
        this.getPageableProducts(this.pageSize, this.pageNumber);
      });
  }

  getPageableProducts(pageSize: number, pageNumber: number) {
    this._productService.getPageableProducts(pageSize, pageNumber)
      .subscribe((res: ResponseModel<Pageable<ProductModel>>) => {
        if (res.code === CodeConstant.SUCCESS) {
          this.listProducts = res.data.content;
          this.totalItems = res.data.totalElements;
        }
      })
  }

  pageSizeChange($event: PageEvent) {
    return this._router.navigateByUrl(`/products?size=${$event.pageSize}&page=${$event.pageIndex}`);
  }

  editProduct(product: ProductModel) {
    return this._router.navigateByUrl(`/product-business?id=${product.laptopId}`)
  }

  changeStatus(product: ProductModel) {
    this._productService.changeStatus(product)
      .subscribe((res: ResponseModel<number>) => {
        if (res.code === 200) {
          this._notificationService.showSuccess('Đổi trạng thái thành công', res.message, 3000);
          this.getPageableProducts(this.pageSize, this.pageNumber);
        } else {
          this._notificationService.showError('Đổi trạng thái thất bại', res.message, 3000);
        }
      });
  }
}
