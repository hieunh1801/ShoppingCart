import { PromotionBusinessComponent } from './modules/pages/promotion/promotion-business/promotion-business.component';
import { PromotionComponent } from './modules/pages/promotion/promotion.component';
import { OrderComponent } from './modules/pages/order/order.component';
import { InvoiceBusinessComponent } from './modules/pages/invoice/invoice-business/invoice-business.component';
import { InvoiceComponent } from './modules/pages/invoice/invoice.component';
import { ProductsBusinessComponent } from './modules/pages/products/products-business/products-business.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './modules/pages/dashboard/dashboard.component';
import {LoginComponent} from './modules/authentication/login/login.component';
import {LayoutComponent} from './layouts/layout/layout.component';
import {AuthGuard} from './core/guards/auth.guard';
import { ProductsComponent } from './modules/pages/products/products.component';

const ROUTES: Routes = [
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'products',
        component: ProductsComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'product-business',
        component: ProductsBusinessComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'invoice',
        component: InvoiceComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'invoice-business',
        component: InvoiceBusinessComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'order',
        component: OrderComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'promotion',
        component: PromotionComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'promotion-business',
        component: PromotionBusinessComponent,
        canActivate: [AuthGuard],
      },
      // router user profile
      // {
      //   path: 'notifications',
      //   canActivate: [AuthGuard],
      //   component: ListNotificationComponent
      // },
    ]
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  // Handle all other routes
  {path: '**', redirectTo: '/dashboard'}
];


@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
