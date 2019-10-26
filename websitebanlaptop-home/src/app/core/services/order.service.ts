import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
})
export class OrderService {
    constructor(private _http: HttpClient) {}

    createOrder(order: any): Observable<any> {
        return this._http.post('http://localhost:8080/api/order/create', order);
    }
}