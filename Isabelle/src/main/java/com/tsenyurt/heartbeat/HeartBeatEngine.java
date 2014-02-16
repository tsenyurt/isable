package com.tsenyurt.heartbeat;

import java.util.concurrent.ScheduledExecutorService;

public class HeartBeatEngine {
	private long beatRate = 15;
	
	public HeartBeatEngine(long minutes){
		this.beatRate = minutes;
		
	}
	
	private ScheduledExecutorService executor;
	
}
