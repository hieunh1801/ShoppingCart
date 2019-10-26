import { ProductModel } from './../../../../core/models/product.model';
import { ResponseModel } from 'src/app/core/models/response.model';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from './../../../../core/services/product.service';
import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from 'src/app/shared/services/shopping-cart.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  product: ProductModel;
  constructor(
    private _productService: ProductService,
    private _shoppingCartService: ShoppingCartService,
    private _router: Router,
    private _route: ActivatedRoute
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
          console.log(this.product);
          
        }
      });
  }

  addProductToCart(product: ProductModel): void {
    this._shoppingCartService.addItem(product, 1);
  }

}
