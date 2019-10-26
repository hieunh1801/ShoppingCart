import { CartItemModel } from './cart-item.model';
export class ShoppingCartModel {
    items: CartItemModel[];
    totalItems: number;

    constructor() {
        this.items = [];
        this.totalItems = 0;
    }

    public updateFrom(src: ShoppingCartModel) {
        this.items = src.items;
        this.totalItems = src.totalItems;
    }
}