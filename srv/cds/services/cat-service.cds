using com.sap.di.irp as irp from '../../../db/index';

service CatalogService {
    entity Books @(restrict: [{ grant: ['READ'], to: 'TransactionRead' },{ grant: ['CREATE'], to: 'TransactionCreate' },{ grant: ['UPDATE'], to: 'TransactionUpdate' },{ grant: ['DELETE'], to: 'TransactionDelete' }]) as projection on irp.bookshop.Books;
}