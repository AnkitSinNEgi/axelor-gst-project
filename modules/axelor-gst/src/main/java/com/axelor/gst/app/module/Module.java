package com.axelor.gst.app.module;

import com.axelor.app.AxelorModule;
import com.axelor.gst.app.service.InvoiceLineService;
import com.axelor.gst.app.service.InvoiceLineServiceImpl;
import com.axelor.gst.app.service.InvoiceService;
import com.axelor.gst.app.service.InvoiceServiceImp;
import com.axelor.gst.app.service.SequenceService;
import com.axelor.gst.app.service.SequenceServiceImp;

public class Module extends AxelorModule {
	
	@Override
	protected void configure() {
		bind(InvoiceLineService.class).to(InvoiceLineServiceImpl.class);
		bind(InvoiceService.class).to(InvoiceServiceImp.class);
		bind(SequenceService.class).to(SequenceServiceImp.class);
	}
}
