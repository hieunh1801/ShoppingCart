import { ProductDetailComponent } from './modules/pages/products/product-detail/product-detail.component';
import { CheckoutComponent } from './modules/pages/checkout/checkout.component';
import { ProductsComponent } from './modules/pages/products/products.component';
import { HomeComponent } from './modules/pages/home/home.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LoginComponent} from './modules/authentication/login/login.component';
import {LayoutComponent} from './layouts/layout/layout.component';
import {AuthGuard} from './core/guards/auth.guard';

const ROUTES: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: 'home',
        component: HomeComponent,
        canActivate: []
      },
      {
        path: 'products',
        component: ProductsComponent,
        canActivate: []
      },
      {
        path: 'product-detail',
        component: ProductDetailComponent,
        canActivate: []
      },
      {
        path: 'checkout',
        component: CheckoutComponent,
        canActivate: []
      },
    ]
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  // Handle all other routes
  {path: '**', redirectTo: '/home'}
];


@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
