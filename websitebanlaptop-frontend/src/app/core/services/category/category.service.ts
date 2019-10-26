import { URLConstant } from './../../constants/url.constant';
import { ResponseModel } from 'src/app/core/models/response.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
})
export class CategoryService {
    constructor(private _http: HttpClient) {}

    getPageableCategories(pageSize: number, pageNumber: number): Observable<any> {
        return this._http.get(`${URLConstant.CATEGORIES_GETPAGEABLE}?pageSize=${pageSize}&pageNumber=${pageNumber}`);
    }

    getAll(): Observable<any> {
        return this._http.get(`${URLConstant.CATEGORIES_ALL}`);
    }
}