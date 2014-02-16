package com.tsenyurt.twitter.test;

import java.util.Iterator;
import java.util.List;

import twitter4j.Location;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.api.TrendsResources;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.Status;

public class TwitterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("tLafT3JHxLbbkUiea2EbRg");
		cb.setOAuthConsumerSecret("9zobdmytaj6kZ7w9IUKlLrWcqCAjZX0KVqIenZXgOo");
		cb.setOAuthAccessToken("2298369630-8LhnFjed8U3mDtR018Or92eBkTr7VWe6lRJNltC");
		cb.setOAuthAccessTokenSecret("5u8bMVvQoaXdK9uc0V1fZi30nhREUAOiVPUAGFLpK79Rz");
		  
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
	   
	    List<Status> statuses = null;
		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Showing home timeline.");
	    for (Status status : statuses) {
	        System.out.println(status.getUser().getName() + ":" +
	                           status.getText());
	    }
	    
	    try {
	  
	    	ResponseList<Location> locations;
	    	locations = twitter.getAvailableTrends();
	    	System.out.println("Showing available trends");
	    	StringBuilder sb = new StringBuilder();
	    	for (Location location : locations) {
	    		System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
	    		if (location.getName().equalsIgnoreCase("Turkey")){
	    			TrendsResources tresource = twitter.trends();
	    			Trends trends = tresource.getPlaceTrends(location.getWoeid());
	    			Trend[] trendtopics = trends.getTrends();
	    			
	    			for (int i = 0; i < trendtopics.length; i++) {
	    				
	    				if (i<5)
	    					sb.append(trendtopics[i].getName() + " ");
	    				
	    				
	    			System.out.println("TREND:" + trendtopics[i].getName());
					}
	    			

	    		}
	    	}
	    	if(sb.toString().length()>0)
	    	twitter.sendDirectMessage("tsenyurt", sb.toString());
	    	System.out.println("done.");
	    	
	    } catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
