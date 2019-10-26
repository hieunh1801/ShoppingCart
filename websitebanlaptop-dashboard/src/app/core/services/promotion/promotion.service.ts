import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
})
export class PromotionService {
    constructor(private _http: HttpClient) {}

    getPagePromotions(pageSize: number, pageNumber: number): Observable<any> {
        return this._http.get(`http://localhost:8080/api/promotion/page?size=${pageSize}&page=${pageNumber}`);
    }

    createPromotion(promotion: any): Observable<any> {
        return this._http.post('http://localhost:8080/api/promotion/create', promotion);
    }
}