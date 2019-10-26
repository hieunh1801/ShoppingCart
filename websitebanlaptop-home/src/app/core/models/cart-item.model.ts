export class CartItemModel {
    laptopId: number;
    quantity: number;
    price: number;
    productName: string;
    productImage: string;

    constructor() {
        this.laptopId = 0;
        this.quantity = 0;
        this.price = 0;
    }
}