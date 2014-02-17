package com.tsenyurt.heartbeat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HeartBeatEngine {
	private final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(1);
	private static long heartBeatCount = 0;
	private static long heartBeatRateSeconds = 3;

	private static HeartBeatEngine instance = null;

	protected HeartBeatEngine() {
		// Exists only to defeat instantiation.
	}

	public static HeartBeatEngine getInstance() {
		if (instance == null) {
			instance = new HeartBeatEngine();
		}
		return instance;
	}
	


	public void start() {
		final Runnable beeper = new Runnable() {
			public void run() {
				heartBeatCount++;
				heartBeat();
			}
		};
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, heartBeatRateSeconds, TimeUnit.SECONDS);
	}
	
	
	private void heartBeat(){
		System.out.println("heartbeat:" + heartBeatCount );

		// main loop for isabelle:
		// get the processing pack from inbound
		// apply the plugins and collets action pack
		// check scheduled plugins if any
		// send the action pack to outbound
		
		
	}

}
