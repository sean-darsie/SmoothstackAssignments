package com.smoothstack.java.basics;

import java.util.Random;

//Assignment 2 day 2
public class TwoDimensionalArrayMax {

	public static void main(String[] args) {
		int[][] array = constructRandomIntArray(5);
		
		int maxValue = findMaxInt(array);
		System.out.println("the largest value of this array is "+maxValue);

	}
	
	public static int[][] constructRandomIntArray(int size)
	{
		int[][] array = new int[size][size];
		Random r = new Random();
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				array[i][j] = r.nextInt(100) + 1;
			}
		}
		return array;
	}
	
	public static int findMaxInt(int[][] array)
	{
		int max = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				if (array[i][j] > max)
				{
					max = array[i][j];
				}
			}
		}
		return max;
	}

}
