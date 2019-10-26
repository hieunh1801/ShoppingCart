import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
})
export class SupplierService {
    constructor(private _http: HttpClient) {}

    getAllSuppliers(): Observable<any> {
        return this._http.get('http://localhost:8080/api/supplier/all');
    }
}