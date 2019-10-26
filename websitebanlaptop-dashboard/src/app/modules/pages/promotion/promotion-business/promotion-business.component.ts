import { Router } from '@angular/router';
import { NotificationService } from 'src/app/shared/services/notification.service';
import { ResponseModel } from './../../../../core/models/response.model';
import { ProductModel } from './../../../../core/models/product.model';
import { ProductService } from 'src/app/core/services/product/product.service';
import { PromotionService } from './../../../../core/services/promotion/promotion.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-promotion-business',
  templateUrl: './promotion-business.component.html',
  styleUrls: ['./promotion-business.component.scss']
})
export class PromotionBusinessComponent implements OnInit {
  promotionFormGroup: FormGroup;

  products: ProductModel[];

  constructor(
    private _promotionService: PromotionService,
    private _productService: ProductService,
    private _notificationService: NotificationService,
    private _formBuilder: FormBuilder,
    private _router: Router
  ) { 
    // init form
    this.promotionFormGroup = this._formBuilder.group({
      discount: (0),
      startDate: (''),
      endDate: (''),
      laptopId: ('')
    });
  }

  public get f() {
    return this.promotionFormGroup.controls;
  }
  
  ngOnInit() {
    this.getListProducts();
  }

  getListProducts() {
    this._productService.getAllProducts()
      .subscribe((res: ResponseModel<ProductModel[]>) => {
        if (res.code === 200 ) {
          this.products = res.data;
        }
      });
  }

  submit() {
    const promotion = {
      laptopId: parseInt(this.f.laptopId.value),
      discount: parseInt(this.f.discount.value),
      startDate: parseInt(moment(this.f.startDate.value).format('X')) * 1000,
      endDate: parseInt(moment(this.f.endDate.value).format('X')) * 1000
    };
    this._promotionService.createPromotion(promotion)
      .subscribe((res: ResponseModel<number>) => {
        if (res.code === 200) {
          this._notificationService.showSuccess('Tạo mã khuyến mãi thành công', 'Thành công', 3000);
          this._router.navigateByUrl('/promotion');
        } else {
          this._notificationService.showError('Tạo mã khuyến mãi thất bại', 'Thất bại', 3000);
        }
      }); 
    
  }
}
