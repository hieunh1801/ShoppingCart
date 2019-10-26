import { ResponseModel } from './../../models/response.model';
import { ProductDisplayHome } from './../../models/product-display-home.model';
import { ProductService } from './../../services/product.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.scss']
})
export class ListProductsComponent implements OnInit {
  @Input('title') title: string;

  @Input('category') category: string;

  listProducts: ProductDisplayHome[];
  
  constructor(
    private _productService: ProductService
  ) { }

  ngOnInit() {
    this.getListProducts(this.category);
  }

  getListProducts(category: string) {
    this._productService.getListProducts(category)
      .subscribe((res: ResponseModel<ProductDisplayHome[]>) => {
        if (res.code === 200) {
          this.listProducts = res.data;
        }
      });
  }

}
