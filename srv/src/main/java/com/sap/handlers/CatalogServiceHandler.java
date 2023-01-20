package com.sap.handlers;

import cds.gen.com.sap.di.irp.bookshop.Books;
import cds.gen.com.sap.di.irp.bookshop.Books_;
import cds.gen.com.sap.di.irp.bookshop.Bookshop_;
import cds.gen.catalogservice.CatalogService_;
import com.sap.cds.Result;
import com.sap.cds.ql.Insert;
import com.sap.cds.ql.cqn.CqnInsert;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@ServiceName(CatalogService_.CDS_NAME)
public class CatalogServiceHandler implements EventHandler {

	@Autowired
	private PersistenceService db;

	@After(event = CdsService.EVENT_READ)
	public void discountBooks(Stream<Books> books) {
		books.filter(b -> b.getTitle() != null && b.getStock() != null)
		.filter(b -> b.getStock() > 200)
		.forEach(b -> b.setTitle(b.getTitle() + " (discounted)"));
	}

	@On(event = CdsService.EVENT_CREATE, entity = "CatalogService.Books")
	public void createBooks(CdsCreateEventContext context, Books books) {
		Result result = null;
		CqnInsert insert = null;
		insert = Insert.into(Books_.class).entry(books);
		result = db.run(insert);
	}

}