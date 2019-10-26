import { NotificationService } from './../../../shared/services/notification.service';
import { OrderService } from './../../../core/services/order.service';
import { UserModel } from 'src/app/core/models/user.model';
import { ResponseModel } from './../../../core/models/response.model';
import { ProductService } from './../../../core/services/product.service';
import { ProductModel } from './../../../core/models/product.model';
import { ShoppingCartModel } from './../../../core/models/shopping-cart.model';
import { ShoppingCartService } from './../../../shared/services/shopping-cart.service';
import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {
  public cartObs: Observable<ShoppingCartModel>;

  cart: ShoppingCartModel;

  private products: ProductModel[];

  currentUser: UserModel;

  promotionValue = "";

  constructor(
    private _shoppingCartService: ShoppingCartService,
    private _productService: ProductService,
    private _orderService: OrderService,
    private _notificationService: NotificationService
  ) { }

  ngOnInit() {
    this.cartObs = this._shoppingCartService.get();
    this.cartObs.subscribe((result) => {
      this.cart = result;
      if (this.cart.totalItems > 0) {
        this.getListProductsInCart(this.cart);
      }
    });

    this.getCurrentUser();
  }

  getCurrentUser() {
    if (localStorage.getItem('current_user')) {
      this.currentUser = JSON.parse(localStorage.getItem('current_user')) as UserModel;
    }
  }

  getListProductsInCart(cart: ShoppingCartModel) {
    let ids = [];
    cart.items.map((item) => {
      ids.push(item.laptopId);
    });
    this._productService.getListProductsByIds(ids)
      .subscribe((res: ResponseModel<ProductModel[]>) => {
        if (res.code === 200) {
         this. products = res.data;
          this.products.forEach((product) => {
            this.cart.items.forEach((item) => {
              if (item.laptopId === product.laptopId) {
                item.productName = product.name;
                item.productImage = product.image;
              }
            })
          });

        }
      });
  }

  getTotalPrice() {
    let totalPrice = 0;
    this.cart.items.forEach((item) => {
      totalPrice = totalPrice + item.price * item.quantity
    });

    return totalPrice;
  }

  changeValue(amount: any, product: any) {
    const updatedProduct = this.products.filter((item) => item.laptopId === product.productId)[0];
    this._shoppingCartService.addItem(updatedProduct, parseInt(amount));
  }

  checkout() {
    const data = {
      listProducts: this.cart.items,
      promotionValue: this.promotionValue
    }
    this._orderService.createOrder(data)
      .subscribe((res: ResponseModel<number>) => {
        if (res.code === 200) {
          this._notificationService.showSuccess('Đặt hàng thành công', 'Thành công', 3000);
          this._shoppingCartService.empty();
        }
      });
  }

  getTotalItems() {
    return this.cart.totalItems;
  }

}
