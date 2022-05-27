package com.axelor.gst.app.controller;
import java.util.ArrayList;

import com.axelor.gst.app.Sequence;
import com.axelor.gst.app.service.SequenceService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

//public class SequenceController{
//	
//	public void getSequence(ActionRequest req, ActionResponse resp)
//	{
//		Sequence sequence=req.getContext().asType(Sequence.class);
//		 resp.setValue("nextNumber",nextNumber );
//		
//	}
//}


public class SequenceController {

	@Inject
	private SequenceService service;
	
	public void getSequence(ActionRequest req,ActionResponse resp) {
		
		Sequence sequence = req.getContext().asType(Sequence.class);
		
		resp.setValue("nextNumber", (service.getNextNumber(sequence)));
		//System.out.println(sequence);
	}
}

