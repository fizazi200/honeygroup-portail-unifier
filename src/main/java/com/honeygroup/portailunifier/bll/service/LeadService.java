package com.honeygroup.portailunifier.bll.service;

import com.honeygroup.portailunifier.bo.DemandeLead;
import com.honeygroup.portailunifier.bo.request.LeadRequest;

public interface LeadService {

	DemandeLead createLead(LeadRequest request);
}
