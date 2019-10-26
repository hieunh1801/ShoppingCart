import { UserService } from './../../core/services/user.service';
import {Component, OnInit} from '@angular/core';
import {detectBody} from '../../core/helper/app.helpers';
import {ShareService} from '../../shared/services/share.service';
import { ResponseModel } from 'src/app/core/models/response.model';
import { UserModel } from 'src/app/core/models/user.model';


@Component({
  selector: 'app-layout',
  templateUrl: 'layout.component.html',
  host: {
    '(window:resize)': 'onResize()'
  }
})
export class LayoutComponent implements OnInit {

  constructor(
  ) {
  }

  ngOnInit(): void {
    detectBody();
  }

  

  onResize(): void {
    detectBody();
  }
}
