import { CategoryModel } from './category.model';
export interface ProductModel {
    laptopId: number;
    name: string;
    title: string;
    description: string;
    quantity: number;
    size: string;
    weight: string;
    height: string;
    color: string;
    image: string;
    memory: string;
    os: string;
    ram: string;
    cpu: string;
    battery: string;
    status: number;
    category: CategoryModel;
    price: number;
}