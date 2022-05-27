package com.axelor.gst.app.service;

import java.math.BigDecimal;

import com.axelor.gst.app.Invoice;
import com.axelor.gst.app.InvoiceLine;
import com.axelor.gst.app.Product;
import com.axelor.gst.app.State;



public class InvoiceLineServiceImpl implements InvoiceLineService {

	@Override
	public boolean checkState(State s1, State s2) {
		
		if(s1.getName().equalsIgnoreCase(s2.getName()))
			return true;
		
		return false;
	}

	
	@Override
	public InvoiceLine getGstAmounts(Invoice invoice, InvoiceLine invoiceLine) {
		
		BigDecimal netAmount=invoiceLine.getNetAmount();
		
		BigDecimal igst=netAmount.multiply(invoiceLine.getGstRate().divide(BigDecimal.valueOf(100)));
		
		BigDecimal gst=igst.divide(BigDecimal.valueOf(2));
		
		BigDecimal grossAmount=netAmount;
		
		if(checkState(invoice.getCompany().getAddress().getState(), invoice.getInvoiceAddress().getState())) {
			
			invoiceLine.setSgst(gst);

			invoiceLine.setCgst(gst);
		}
		else 
			invoiceLine.setIgst(igst);
			
		grossAmount=grossAmount.add(igst);
		
		invoiceLine.setGrossAmount(grossAmount);
		
		return invoiceLine;
	}

	
	
	@Override
	public String getProductCode(InvoiceLine invoiceLine) {
		
		Product product=invoiceLine.getProduct();
		
		return "["+product.getCode()+"] "+product.getName();
	}

}























