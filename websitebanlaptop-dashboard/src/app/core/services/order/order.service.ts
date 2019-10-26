import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
})
export class OrderService {

    constructor(private _http: HttpClient) { }

    getPagebleOrders(pageSize: number, pageNumber: number): Observable<any> {
        return this._http.get(`http://localhost:8080/api/order/page?size=${pageSize}&number=${pageNumber}`)
    }

    getOrderDetailById(id: any): Observable<any> {
        return this._http.get(`http://localhost:8080/api/order/get-order-by-id/${id}`);
    }
}