import { ProductModel } from './product.model';
export class PromotionModel {
    promotionId: number;
    value: string;
    discount: number;
    startDate: number;
    endDate: number;
    laptop: ProductModel
}