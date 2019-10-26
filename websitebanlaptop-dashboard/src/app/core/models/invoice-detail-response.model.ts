import { InvoiceDetailModel } from './invoice-detail.model';
export interface InvoiceDetailResponseModel {
    invoiceId: number,
    supplierName: string,
    notes: string,
    createdDate: number,
    listInvoiceDetails: InvoiceDetailModel[]
}