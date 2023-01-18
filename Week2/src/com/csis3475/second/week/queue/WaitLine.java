package com.csis3475.second.week.queue;
import com.csis3475.second.week.queue.*;

/** Simulates a waiting line. 
@author Frank M. Carrano
@author Timothy M. Henry
@version 5.0
@author minor modification by Bambang
*/
public class WaitLine
{
	private QueueInterface<Customer> line;
	private int numberOfCustomers;
	private int numberServed;
	private int totalTimeWaited;
	
	public WaitLine()
	{
	  line = new LinkedQueue<>();
	  // reset the line 
	  line.clear();
	  numberOfCustomers = 0;
	  numberServed = 0;
	  totalTimeWaited = 0;
	
	} // end default constructor
	
	/** Simulates a waiting line with one serving agent.
	   @param duration  The number of simulated minutes.
	   @param arrivalProbability  A real number between 0 and 1, and the
	                              probability that a customer arrives at
	                              a given time
	   @param maxTransactionTime  The longest transaction time for a
	                              customer */ 
	public void simulate(int duration, double arrivalProbability, 
	                    int maxTransactionTime)
	{
	  int transactionTimeLeft = 0;
	
	  for (int clock = 0; clock < duration; clock++)
	  {
	     if (Math.random() < arrivalProbability)
	     {
	        numberOfCustomers++; // used as customerNumber
	        int transactionTime = (int)(Math.random() * maxTransactionTime + 1);
	        Customer nextArrival = new Customer(clock, transactionTime, 
	                                            numberOfCustomers);
	        line.enqueue(nextArrival);
	        System.out.println("\nCustomer " + numberOfCustomers +
	                           " enters line at time " + clock +
	                           ". Transaction time is " + transactionTime);
	     } // end if
	
	     if (transactionTimeLeft > 0)
	        transactionTimeLeft--;
	     else if (!line.isEmpty())
	     {
	        Customer nextCustomer = line.dequeue();
	        transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
	        int timeWaited = clock - nextCustomer.getArrivalTime();
	        totalTimeWaited = totalTimeWaited + timeWaited;
	        numberServed++;
	        System.out.println("\tCustomer " + nextCustomer.getCustomerNumber() +
	                           " begins service at time " + clock +
	                           ". Time waited is " + timeWaited);
	     } // end if
	  } // end for
	} // end simulate
	
	/** Displays summary results of the simulation. */ 
	public void displayResults()
	{
	  System.out.println();
	  System.out.println("Number served = " + numberServed);
	  System.out.println("Total time waited = " + totalTimeWaited);
	  double averageTimeWaited = ((double)totalTimeWaited) / numberServed;
	  System.out.println("Average time waited = " + averageTimeWaited);
	  int leftInLine = numberOfCustomers - numberServed;
	  System.out.println("Number left in line = " + leftInLine);
	} // end displayResults

} // end WaitLine
