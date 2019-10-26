import { HeaderComponent } from './../header/header.component';
import {NgModule} from '@angular/core';
import {FooterComponent} from '../footer/footer.component';
import {TopnavbarComponent} from '../topnavbar/topnavbar.component';
import {LayoutComponent} from './layout.component';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {BsDropdownModule} from 'ngx-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MaterialModule} from '../../shared/material.module';

@NgModule({
  imports: [
    BrowserModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule,
    BsDropdownModule.forRoot(),
  ],
  declarations: [
    FooterComponent,
    TopnavbarComponent,
    LayoutComponent,
    HeaderComponent
  ],
  exports: [
    FooterComponent,
    LayoutComponent,
    TopnavbarComponent,
    HeaderComponent
  ]
})
export class LayoutModule {
}
