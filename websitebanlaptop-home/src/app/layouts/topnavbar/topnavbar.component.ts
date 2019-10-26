import { UserService } from './../../core/services/user.service';
import { UserModel } from './../../core/models/user.model';
import { ShareService } from './../../shared/services/share.service';
import {Component, OnDestroy, OnInit} from '@angular/core';
import {smoothlyMenu} from '../../core/helper/app.helpers';
import {AuthService} from '../../core/services/auth/auth.service';
import {Router} from '@angular/router';
import 'rxjs/add/operator/distinctUntilChanged';
import { Observable } from 'rxjs';
import { ShoppingCartModel } from 'src/app/core/models/shopping-cart.model';
import { ShoppingCartService } from 'src/app/shared/services/shopping-cart.service';
import { ResponseModel } from 'src/app/core/models/response.model';

declare var jQuery: any;

@Component({
  selector: 'app-topnavbar',
  styleUrls: ['topnavbar.component.scss'],
  templateUrl: 'topnavbar.component.html'
})
export class TopnavbarComponent implements OnInit, OnDestroy {
  public cartObs: Observable<ShoppingCartModel>;

  cart: ShoppingCartModel;

  currentUser: UserModel;

  constructor(
    private _shoppingCartService: ShoppingCartService,
    private _userService: UserService,
    private _shareService: ShareService,
    private router: Router,
    private authService: AuthService,
  ) {
  }

  ngOnInit(): void {
    this.cartObs = this._shoppingCartService.get();
    this.cartObs.subscribe((result) => {
      this.cart = result;
    });

    if (localStorage.getItem('access_token')) {
      this.getCurrentUser();
    }

    this._shareService.currentUserStream$.subscribe((user: UserModel) => {
      if (this.currentUser === undefined) {
        this.currentUser = user;
      }
      if (user === undefined) {
        this.currentUser = undefined;
      }
    });
  }

  getCurrentUser() {
    this._userService.getCurrentUser()
      .subscribe((res: ResponseModel<UserModel>) => {
        if (res.code === 200) {
          this._shareService.broadcastCurrentUserChange(res.data);

          localStorage.setItem('current_user', JSON.stringify(res.data));
        }
      });
  }

  logout() {
    this.authService.logout();
    localStorage.removeItem('current_user');
    this._shareService.broadcastCurrentUserChange(undefined);
    return this.router.navigate(['/home']);
  }

  

  toggleNavigation(): void {
    jQuery('body').toggleClass('mini-navbar');
    smoothlyMenu();
  }

  ngOnDestroy(): void {
  }
}
