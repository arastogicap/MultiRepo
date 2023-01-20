using com.sap.di.irp as irp from '../../../db/index';

service MasterDataService @(requires: 'authenticated-user') {
    entity Address @(restrict: [{ grant: ['READ'], to: 'MasterDataRead' },{ grant: ['CREATE'], to: 'MasterDataCreate' },{ grant: ['UPDATE'], to: 'MasterDataUpdate' },{ grant: ['DELETE'], to: 'MasterDataDelete' }]) as projection on irp.address.Addresses;
}