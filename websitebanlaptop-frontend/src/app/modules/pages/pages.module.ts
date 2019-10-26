import { DashboardComponent } from './dashboard/dashboard.component';

import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { MaterialModule } from 'src/app/shared/material.module';
import { ProductsComponent } from './products/products.component';
import { ProductsBusinessComponent } from './products/products-business/products-business.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { InvoiceComponent } from './invoice/invoice.component';
import { InvoiceBusinessComponent } from './invoice/invoice-business/invoice-business.component';
import { OrderComponent } from './order/order.component';
import { PromotionComponent } from './promotion/promotion.component';
import { PromotionBusinessComponent } from './promotion/promotion-business/promotion-business.component';

@NgModule({
  declarations: [
    DashboardComponent,
    ProductsComponent,
    ProductsBusinessComponent,
    InvoiceComponent,
    InvoiceBusinessComponent,
    OrderComponent,
    PromotionComponent,
    PromotionBusinessComponent,
  ],
  imports: [
    // Core Module
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    // Mat Module
    MaterialModule,
    // Ck editor
    CKEditorModule,
  ],
  exports: [
  ],
  providers: [
  ]
})
export class PagesModule { }
