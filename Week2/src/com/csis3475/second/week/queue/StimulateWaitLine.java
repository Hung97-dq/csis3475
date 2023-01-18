package com.csis3475.second.week.queue;

public class StimulateWaitLine {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitLine customerLine = new WaitLine();
		customerLine.simulate(20,0.5,4);
		customerLine.displayResults();
	}

}
