using com.sap.di.irp as irp from '../../../db/index';

service CatalogService {
    @readonly entity Books as projection on irp.bookshop.Books;
}