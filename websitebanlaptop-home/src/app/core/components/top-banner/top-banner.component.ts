import { ResponseModel } from 'src/app/core/models/response.model';
import { SupplierModel } from './../../models/supplier.model';
import { SupplierService } from './../../services/supplier.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-top-banner',
  templateUrl: './top-banner.component.html',
  styleUrls: ['./top-banner.component.scss']
})
export class TopBannerComponent implements OnInit {
  listSuppliers: SupplierModel[];
  constructor(
    private _supplierService: SupplierService
  ) { }

  ngOnInit() {
    this.getListSuppliers();
  }

  getListSuppliers() {
    this._supplierService.getListSuppliers()
      .subscribe((res: ResponseModel<SupplierModel[]>) => {
        if (res.code === 200) {
          this.listSuppliers = res.data;
        }
      });
  }

}
