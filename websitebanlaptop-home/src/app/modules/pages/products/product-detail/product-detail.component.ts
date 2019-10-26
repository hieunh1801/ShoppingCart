import { ProductModel } from './../../../../core/models/product.model';
import { ResponseModel } from 'src/app/core/models/response.model';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from './../../../../core/services/product.service';
import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from 'src/app/shared/services/shopping-cart.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  product: ProductModel;
  // store innerHtml article
  articleHTML: any;
  constructor(
    private _productService: ProductService,
    private _shoppingCartService: ShoppingCartService,
    private _router: Router,
    private _route: ActivatedRoute,
    private _sanitizer: DomSanitizer,
  ) { }

  ngOnInit() {
    this._route.queryParams.subscribe((params) => {
      if (params.id) {
        this.getProductDetailById(params.id);
      }
    });
  }

  getProductDetailById(id: any) {
    this._productService.getProductDetailById(id)
      .subscribe((res: ResponseModel<ProductModel>) => {
        if (res.code === 200) {
          this.product = res.data;
        }
      });
  }

  addProductToCart(product: ProductModel): void {
    this._shoppingCartService.addItem(product, 1);
  }

  ngAfterContentChecked() {
    if (this.product) {
      this.articleHTML = this._sanitizer.bypassSecurityTrustHtml(this.product.description);
    }
  }

}
