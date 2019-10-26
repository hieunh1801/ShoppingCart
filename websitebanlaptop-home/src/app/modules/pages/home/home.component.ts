import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  titleNewProducts = 'Sản phẩm mới nhất';

  categoryNewProducts = 'all';

  titlePromotionProducts = 'Sản phẩm đang khuyến mãi';

  categoryPromotionProducts = 'get-products-promotion';

  constructor() { }

  ngOnInit() {
  }

}
