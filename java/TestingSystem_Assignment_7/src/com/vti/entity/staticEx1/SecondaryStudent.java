package com.vti.entity.staticEx1;

public final class SecondaryStudent extends Student{
	public static int counterSecondary = 0;
	
	public SecondaryStudent(String name) throws Exception {
        super(name);
        counterSecondary ++;
    }
}
