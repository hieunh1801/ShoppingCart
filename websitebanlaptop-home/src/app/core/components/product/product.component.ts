import { Router } from '@angular/router';
import { ProductService } from './../../services/product.service';
import { ShoppingCartService } from './../../../shared/services/shopping-cart.service';
import { ProductModel } from './../../models/product.model';
import { ProductDisplayHome } from './../../models/product-display-home.model';
import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  public products: Observable<ProductModel[]>;

  @Input('listProducts') listProducts: ProductDisplayHome[];

  constructor(
    private _productService: ProductService,
    private _router: Router
  ) { }

  ngOnInit() {
    this.products = this._productService.getListProducts('all');
  }
  
  viewProductDetail(product: ProductModel) {
    return this._router.navigateByUrl(`/product-detail?id=${product.laptopId}`);
  }
}
