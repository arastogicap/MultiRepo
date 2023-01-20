package com.sap.handlers;

import cds.gen.masterdataservice.*;
import cds.gen.com.sap.di.irp.address.Addresses;
import com.sap.cds.services.cds.*;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@ServiceName(MasterDataService_.CDS_NAME)
public class AddressHandler implements EventHandler {

	@After(event = CdsService.EVENT_READ,entity = "MasterDataService.Address")
	public void readAddress(CdsReadEventContext context, Address addressItem) {

	}

}