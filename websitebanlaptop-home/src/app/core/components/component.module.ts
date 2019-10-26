import { BrowserModule } from '@angular/platform-browser';
import { MaterialModule } from 'src/app/shared/material.module';
import {NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListProductsComponent } from './list-products/list-products.component';
import { TopBannerComponent } from './top-banner/top-banner.component';
import { NewsLetterComponent } from './news-letter/news-letter.component';
import { ProductComponent } from './product/product.component';

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    MaterialModule
  ],
  declarations: [
    ListProductsComponent, 
    TopBannerComponent, 
    NewsLetterComponent, 
    ProductComponent
  ],
  entryComponents: [
  ],
  exports: [
    ListProductsComponent,
    TopBannerComponent,
    NewsLetterComponent,
    ProductComponent
  ],
  providers: []
})
export class ComponentModule {
}
