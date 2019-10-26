import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class ProductService {
    constructor(private _http: HttpClient) {}

    getListProducts(category: string): Observable<any> {
        return this._http.get(`http://localhost:8080/home/product/${category}`);
    }

    getListProductsByIds(ids: number[]): Observable<any> {
        return this._http.get(`http://localhost:8080/home/product/get-laptops-by-ids/${ids}`);
    }

    getProductDetailById(id: number): Observable<any> {
        return this._http.get(`http://localhost:8080/api/products/getbyid/${id}`);
    }
}