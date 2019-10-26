import { ProductModel } from 'src/app/core/models/product.model';
import { URLConstant } from './../../constants/url.constant';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http: HttpClient) { }

  getAllProducts(): Observable<any> {
    return this._http.get('http://localhost:8080/api/products/all');
  }

  getPageableProducts(pageSize: number, pageNumber: number): Observable<any> {
    return this._http.get(`${URLConstant.PRODUCTS_GETPAGEABLE}?size=${pageSize}&page=${pageNumber}`);
  }

  uploadImage(file: any): Observable<any> {
    const formData = new FormData();
    formData.append('image', file);

    return this._http.post(`${URLConstant.PRODUCTS_UPLOAD_IMG}`, formData);
  }

  create(data: any): Observable<any> {
    const formData = new FormData();
    formData.append('image', data.image);
    formData.append('name', data.name);
    formData.append('title', data.title);
    formData.append('description', data.description);
    formData.append('size', data.size);
    formData.append('weight', data.weight);
    formData.append('height', data.height);
    formData.append('color', data.color);
    formData.append('memory', data.memory);
    formData.append('os', data.os);
    formData.append('ram', data.ram);
    formData.append('cpu', data.cpu);
    formData.append('battery', data.battery);
    formData.append('categoryId', data.categoryId);

    return this._http.post<any>(`${URLConstant.PRODUCTS_CREATE}`, formData);
  }

  update(data: any): Observable<any> {
    const formData = new FormData();
    formData.append('laptopId', data.productId);
    formData.append('image', data.image);
    formData.append('name', data.name);
    formData.append('title', data.title);
    formData.append('description', data.description);
    formData.append('size', data.size);
    formData.append('weight', data.weight);
    formData.append('height', data.height);
    formData.append('color', data.color);
    formData.append('memory', data.memory);
    formData.append('os', data.os);
    formData.append('ram', data.ram);
    formData.append('cpu', data.cpu);
    formData.append('battery', data.battery);
    formData.append('categoryId', data.categoryId);

    return this._http.put<any>(`${URLConstant.PRODUCTS_UPDATE}`, formData);
  }

  changeStatus(product: ProductModel) {
    let status = (product.status === 0) ? 1 : 0;
    const body = {
      laptopId: product.laptopId,
      status
    }
    return this._http.put(`${URLConstant.PRODUCTS_CHANGE_STATUS}`, body);
  }

  getProductById(productId: number): Observable<any> {
    return this._http.get(`${URLConstant.PRODUCTS_GETBYID}/${productId}`)
  }
}
