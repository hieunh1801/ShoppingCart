import { Pageable } from './../../../core/models/pageable.model';
import { ResponseModel } from 'src/app/core/models/response.model';
import { PromotionService } from './../../../core/services/promotion/promotion.service';
import { PromotionModel } from './../../../core/models/promotion.model';
import { Component, OnInit } from '@angular/core';
import { VariablesConstant } from 'src/app/core/constants/variables.constant';
import { ActivatedRoute, Router } from '@angular/router';
import { PageEvent } from '@angular/material';

@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.scss']
})
export class PromotionComponent implements OnInit {
  promotions: PromotionModel[];

  totalItems: number;
  // page size of table
  pageSize = VariablesConstant.PAGE_SIZE;
  // page number of table
  pageNumber = VariablesConstant.PAGE_NUMBER;
  constructor(
    private _promotionService: PromotionService,
    private _route: ActivatedRoute,
    private _router: Router) { }
  
  

  ngOnInit() {
    this._route.queryParams
      .subscribe((params) => {
        if (params.size) {
          this.pageSize = params.size;
        }
        if (params.page) {
          this.pageNumber = params.page;
        }
        this.getPageablePromotions(this.pageSize, this.pageNumber);
      });
  }

  getPageablePromotions(pageSize: number, pageNumber: number) {
    this._promotionService.getPagePromotions(pageSize, pageNumber)
      .subscribe((res: ResponseModel<Pageable<PromotionModel>>) => {
        if (res.code === 200) {
          this.promotions = res.data.content;
          this.totalItems = res.data.totalElements;
        }
      });
  }

  pageSizeChange($event: PageEvent) {
    return this._router.navigateByUrl(`/promotion?size=${$event.pageSize}&page=${$event.pageIndex}`);
  }

}
