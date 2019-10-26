import { ProductService } from './../../core/services/product.service';
import { CartItemModel } from './../../core/models/cart-item.model';
import { ProductModel } from './../../core/models/product.model';
import { Subject, Observer, Observable } from 'rxjs';
import { Injectable } from "@angular/core";
import { ShoppingCartModel } from 'src/app/core/models/shopping-cart.model';

const CART_KEY = "cart";

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  private subscriptionObservable: Observable<ShoppingCartModel>;
  private subscribers: Array<Observer<ShoppingCartModel>> = new Array<Observer<ShoppingCartModel>>();
  private products: ProductModel[];

  constructor(
    private _productService: ProductService
  ) {
    this.subscriptionObservable = new Observable<ShoppingCartModel>((observer: Observer<ShoppingCartModel>) => {
      this.subscribers.push(observer);
      observer.next(this.retrieve());
      return () => {
        this.subscribers = this.subscribers.filter((obs) => obs !== observer);
      };
    });

    this._productService.getListProducts('all').subscribe((products) => this.products = products);
  }

  public get(): Observable<ShoppingCartModel> {
    return this.subscriptionObservable;
  }

  public addItem(product: ProductModel, quantity: number): void {
    const cart = this.retrieve();
    let item = cart.items.find((p) => p.laptopId === product.laptopId);
    if (item === undefined) {
      const obj = new CartItemModel();
      obj.laptopId = product.laptopId;
      obj.price = product.price;
      obj.quantity = quantity
      cart.items.push(obj);
    } else {
      item.quantity += quantity;
      cart.items = cart.items.filter((cartItem) => cartItem.quantity > 0);
    }

    this.calculateCart(cart);
    this.save(cart);
    this.dispatch(cart);
  }

  private calculateCart(cart: ShoppingCartModel): void {
    // cart.totalItems = cart.items
    //                       .map((item) => item.quantity * this.products.find((p) => p.laptopId === item.laptopId).price)
    //                       .reduce((previous, current) => previous + current, 0);
    cart.totalItems = cart.items.length;
  }

  public empty(): void {
    const newCart = new ShoppingCartModel();
    this.save(newCart);
    this.dispatch(newCart);
  }

  private retrieve(): ShoppingCartModel {
    const cart = new ShoppingCartModel();
    const storedCart = localStorage.getItem(CART_KEY);
    if (storedCart) {
      cart.updateFrom(JSON.parse(storedCart));
    }

    return cart;
  }

  private save(cart: ShoppingCartModel): void {
    localStorage.setItem(CART_KEY, JSON.stringify(cart));
  }

  private dispatch(cart: ShoppingCartModel): void {
    this.subscribers
      .forEach((sub) => {
        try {
          sub.next(cart);
        } catch (e) {
          // we want all subscribers to get the update even if one errors.
        }
      });
  }
}
