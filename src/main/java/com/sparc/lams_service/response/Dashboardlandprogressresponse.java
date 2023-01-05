package com.sparc.lams_service.response;

import lombok.Data;

@Data
public class Dashboardlandprogressresponse {
	private String landclass;
	private String notstarted;
	private String initial;
	private String processing;
	private String finalst;
	private String total;
	
}
