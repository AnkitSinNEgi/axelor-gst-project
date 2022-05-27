package com.axelor.gst.app.controller;

import java.math.BigDecimal;

import com.axelor.gst.app.Invoice;
import com.axelor.gst.app.InvoiceLine;
import com.axelor.gst.app.service.InvoiceLineService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;


public class InvoiceLineController {
	
	@Inject
	private InvoiceLineService service;
	
	
	public void setItem(ActionRequest req,ActionResponse resp) {
		
		InvoiceLine invoiceLine=req.getContext().asType(InvoiceLine.class);
		
		resp.setValue("item", service.getProductCode(invoiceLine));
	}
	public void setNetAmount(ActionRequest req,ActionResponse resp) {
		
		InvoiceLine invoiceLine=req.getContext().asType(InvoiceLine.class);
		
		resp.setValue("netAmount", invoiceLine.getPrice().multiply(BigDecimal.valueOf(invoiceLine.getQty())));
	}

	public void setGst(ActionRequest req,ActionResponse resp) {
		
		InvoiceLine invoiceLine=req.getContext().asType(InvoiceLine.class);
		
		Invoice invoice=req.getContext().getParent().asType(Invoice.class);
		
		try {
							
			resp.setValue("sgst", service.getGstAmounts(invoice, invoiceLine).getSgst());
		
			resp.setValue("cgst", service.getGstAmounts(invoice, invoiceLine).getCgst());

			resp.setValue("igst", service.getGstAmounts(invoice, invoiceLine).getIgst());
		
			resp.setValue("grossAmount", service.getGstAmounts(invoice, invoiceLine).getGrossAmount());
			
		}catch(Exception e) {
			
		}	
	}

}








