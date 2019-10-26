import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  titleAllProducts = 'Tất cả sản phẩm';

  categoryAllProducts = 'all';
  constructor() { }

  ngOnInit() {
  }

}
