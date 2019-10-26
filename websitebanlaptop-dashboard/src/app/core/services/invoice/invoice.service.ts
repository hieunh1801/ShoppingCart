import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class InvoiceService {
    constructor(private _http: HttpClient) {
    }

    getPagebleInvoices(pageSize: number, pageNumber: number): Observable<any> {
        return this._http.get(`http://localhost:8080/api/invoice/page?size=${pageSize}&page=${pageNumber}`);
    }

    getInvoiceDetailById(invoiceId: number): Observable<any> {
        return this._http.get(`http://localhost:8080/api/invoice/getbyid/${invoiceId}`);
    }

    createInvocie(data: any): Observable<any> {
        return this._http.post('http://localhost:8080/api/invoice/create', data);
    }
}