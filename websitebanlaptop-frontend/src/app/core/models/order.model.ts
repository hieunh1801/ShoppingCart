import { OrderDetailModel } from './order-detail.model';

export interface OrderModel {
    orderId: number,
    userName: string,
    address: string,
    phone: string,
    createdate: number,
    totalPrice: number,
    totalItems: number,

    listOrderDetails: OrderDetailModel[];
}