import { ComponentModule } from './../../core/components/component.module';


import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { MaterialModule } from 'src/app/shared/material.module';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ProductDetailComponent } from './products/product-detail/product-detail.component';

@NgModule({
  declarations: [
  HomeComponent,
  ProductsComponent,
  CheckoutComponent,
  ProductDetailComponent
  ],
  imports: [
    // Core Module
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    // Mat Module
    MaterialModule,

    ComponentModule
  ],
  exports: [
  ],
  providers: [
  ]
})
export class PagesModule { }
