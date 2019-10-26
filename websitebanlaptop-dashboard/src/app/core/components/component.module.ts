import { BrowserModule } from '@angular/platform-browser';
import { MaterialModule } from 'src/app/shared/material.module';
import {NgModule} from '@angular/core';
import { InvoiceDetailDialogComponent } from './invoice-detail-dialog/invoice-detail-dialog.component';
import { CommonModule } from '@angular/common';
import { OrderDetailDialogComponent } from './order-detail-dialog/order-detail-dialog.component';

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    MaterialModule
  ],
  declarations: [
  InvoiceDetailDialogComponent,
  OrderDetailDialogComponent,
  ],
  entryComponents: [
    InvoiceDetailDialogComponent,
    OrderDetailDialogComponent,
  ],
  providers: []
})
export class ComponentModule {
}
