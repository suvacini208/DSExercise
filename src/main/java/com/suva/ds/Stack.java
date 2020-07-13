package com.suva.ds;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Stack<T> {
	
	int INC_SIZE = 10;
	T[] elements;
	int size;
	int currentPointer;
		
	@SuppressWarnings("unchecked")
	public Stack() {
		size = INC_SIZE;
		elements = (T[])new Object[size];
	}
	
	public void push(T element) {
		if(!hasCapacity()) {
			resize();
		}
		elements[currentPointer] = element;
		currentPointer++;
	}
	
	private void resize() {
		int newSize = size+INC_SIZE;
		elements = Arrays.copyOf(elements, newSize);
	}

	private boolean hasCapacity() {
		return currentPointer < size;
	}

	public T pop() {
		T newElement = elements[currentPointer-1];
		elements[currentPointer-1] = null;
		size--;
		currentPointer--;
		return newElement;
	}
	
	public String toString() {
		return Arrays.asList(elements).stream()
				.filter(element -> element != null).map(element -> element.toString())
				.collect(Collectors.joining(","));
	}

	public static void main(String[] args) {
		System.out.println("Test");
		Stack<String> pupStack = new Stack<String>();
		pupStack.push("Suva");
		pupStack.push("Subbu");
		pupStack.push("Ambu");
		
		System.out.println(pupStack.pop());
		System.out.println(pupStack);
	}
}
