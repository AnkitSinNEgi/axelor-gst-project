package com.axelor.gst.app.service;

import com.axelor.gst.app.Invoice;
import com.axelor.gst.app.InvoiceLine;
import com.axelor.gst.app.State;


public interface InvoiceLineService {
	
	public boolean checkState(State s1,State s2);
	
	public InvoiceLine getGstAmounts(Invoice invoice,InvoiceLine invoiceLine);
	
	public String getProductCode(InvoiceLine invoiceLine);
}