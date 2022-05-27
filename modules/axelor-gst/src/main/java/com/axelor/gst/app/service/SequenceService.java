package com.axelor.gst.app.service;

import com.axelor.gst.app.Sequence;

//public interface SequenceService{
//	public String getNextNumber(Sequence sequence);
//	
//}


public interface SequenceService {
	public String getNextNumber(Sequence seq);
	public String getPaddingString(String seq,int padding);
	public String incrementedSequence(Sequence sequence);
	public String getNextSequence(String modelName);
}


