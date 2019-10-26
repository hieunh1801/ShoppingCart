export interface Pageable<T> {
    content: T[];
    pageable: any;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    numberOfElements: number;
    sort: any;
    first: boolean;
    empty: boolean;
}