package com.csis3475.second.week;

import java.util.EmptyStackException;

public class GreetingStack {
	public static void main(String[] args) {
		StackInterface<String> stringStack = new ArrayStack<String>();
		if(stringStack.isEmpty()){
			System.out.println("The stack is empty");
		}
		else {
			try {
				stringStack.pop();
			}
			catch(EmptyStackException e) {
				System.out.println("Error: Stack is " + e.getMessage());
				
			}
		}
		
		stringStack.push("Hello");
		stringStack.push("World");
		stringStack.push("Greeting");
		stringStack.push("Earthlings");
		stringStack.push("We come to");
		stringStack.push("Distroy the plannet");
		System.out.println("Our mission is to "+ stringStack.pop());
		stringStack.push("Save the planet");
		
		StackInterface<String> stringStack2 = new ArrayStack();
		while(!stringStack.isEmpty()) {
			stringStack2.push(stringStack.pop());
		}
		
		while(!stringStack2.isEmpty()) {
			System.out.println(stringStack2.pop());
		}
	}
	
	
	
}


