import { ProductModel } from 'src/app/core/models/product.model';
import { NotificationService } from './../../../../shared/services/notification.service';
import { Component, OnInit, ElementRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CategoryModel } from 'src/app/core/models/category.model';
import { Router, ActivatedRoute } from '@angular/router';
import { CategoryService } from 'src/app/core/services/category/category.service';
import { ProductService } from 'src/app/core/services/product/product.service';
import { ResponseModel } from 'src/app/core/models/response.model';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { NotificationConstant } from 'src/app/core/constants/notification.constant';
@Component({
  selector: 'app-products-business',
  templateUrl: './products-business.component.html',
  styleUrls: ['./products-business.component.scss']
})
export class ProductsBusinessComponent implements OnInit {

  productFormGroup: FormGroup;
  // list of images
  private fileImages: any[] = [];
  // store src of image
  thumbnailSrc: any;
  // categories
  categories: CategoryModel[] = [];
  // config ckeditor
  public config = ClassicEditor;
  // product
  product: ProductModel;
  // flag
  isUpdate = false;

  constructor(
    private formBuilder: FormBuilder,
    private _notificationService: NotificationService,
    private _categoryService: CategoryService,
    private _productService: ProductService,
    private _router: Router,
    private _route: ActivatedRoute,
  ) {
    // initial form
    this.productFormGroup = this.formBuilder.group({
      productId: [0],
      name: ['', [Validators.required]],
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      size: ['', [Validators.required]],
      weight: ['', [Validators.required]],
      height: ['', [Validators.required]],
      color: ['', [Validators.required]],
      memory: ['', [Validators.required]],
      os: ['', [Validators.required]],
      ram: ['', [Validators.required]],
      cpu: ['', [Validators.required]],
      battery: ['', [Validators.required]],
      categoryId: ['', [Validators.required]]
    });
  }

  private get f() {
    return this.productFormGroup.controls;
  }

  ngOnInit() {
    this._route.queryParams
      .subscribe((params) => {
        if (params.id) {
          this.getProductById(params.id);
          this.isUpdate = true;
        }
      });
    this.getListCategories();
  }

  getProductById(productId: number) {
    this._productService.getProductById(productId)
      .subscribe((res: ResponseModel<ProductModel>) => {
        if (res.code === 200) {
          this.product = res.data;
          // set value form
          this.setValueForm(res.data);
        }
      });
  }

  setValueForm(product: ProductModel) {
    this.productFormGroup.patchValue({
      productId: product.laptopId,
      name: product.name,
      title: product.title,
      description: product.description,
      size: product.size,
      weight: product.weight,
      height: product.height,
      color: product.color,
      memory: product.memory,
      os: product.os,
      ram: product.ram,
      cpu: product.cpu,
      battery: product.battery,
      categoryId: product.category.categoryId
    });
    this.thumbnailSrc = product.image;
  }

  changeThumbnail(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.thumbnailSrc = e.target.result;
      };
      reader.readAsDataURL(event.target.files[0]);
    }
    this.fileImages = event.target.files;
  }

  getListCategories() {
    this._categoryService.getAll()
      .subscribe((res: ResponseModel<CategoryModel[]>) => {
        if (res.code === 200) {
          this.categories = res.data;
        }
      })
  }

  /**
   * @description function detect event update image in ckedtor
   * we must use UpdateAdapter to custom apdater to update image in our server
   * @param event any
   */
  onReady(event: any) {
    event.plugins.get('FileRepository').createUploadAdapter = (loader: any) => {
      return new UploadAdapter(loader, this._productService);
    };
  }

  submit() {
    const product = {
      productId: this.f.productId.value,
      image: this.fileImages[0],
      name: this.f.name.value.toString().trim(),
      title: this.f.title.value.toString().trim(),
      description: this.f.description.value.toString().trim(),
      size: this.f.size.value.toString().trim(),
      weight: this.f.weight.value.toString().trim(),
      height: this.f.height.value.toString().trim(),
      color: this.f.color.value.toString().trim(),
      memory: this.f.memory.value.toString().trim(),
      os: this.f.os.value.toString().trim(),
      ram: this.f.ram.value.toString().trim(),
      cpu: this.f.cpu.value.toString().trim(),
      battery: this.f.battery.value.toString().trim(),
      categoryId: this.f.categoryId.value.toString().trim()
    }

    if (this.isUpdate) {
      this._productService.update(product)
        .subscribe((res: ResponseModel<number>) => {
          if (res.code === 200) {
            this._notificationService.showSuccess(NotificationConstant.UPDATE_SUCCESS, res.message, 3000);
            this._router.navigateByUrl('/products');
          } else {
            this._notificationService.showError(NotificationConstant.UPDATE_ERROR, res.message, 3000);
          }
        });
    } else {
      this._productService.create(product)
        .subscribe((res: ResponseModel<number>) => {
          if (res.code === 200) {
            this._notificationService.showSuccess(NotificationConstant.CREATE_SUCCESS, res.message, 3000);
            this._router.navigateByUrl('/products');
          } else {
            this._notificationService.showError(NotificationConstant.CREATE_ERROR, res.message, 3000);
          }
        });
    }
  }

  cancel() {
    this._router.navigateByUrl('/products')
  }
}

/**
 * @description custom UpdateAdapter of Ckeditor
 */
export class UploadAdapter {
  private loader: any;

  constructor(
    loader: any,
    private _productService: ProductService) {
    this.loader = loader;
  }

  /**
   * @description upload image to our server
   * @returns Promise<any>
   */
  public upload(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      this.loader.file.then((data: any) => {
        this._productService.uploadImage(data)
          .subscribe((res: ResponseModel<String>) => {
            if (res.code === 200) {
              // if successfully, return {default: url_image}
              resolve({ default: res.data });
            }
          }, () => {
            reject(data.msg);
          });
      });
    });
  }

}
