package com.scale.test;


import org.junit.Test;

public class NumberTest {

	@Test
	public void test() {
		String s = "12345";
        for(int i = s.length(); i > 0; i--){
            for(int j = 0; i + j <= s.length(); j++){
                System.out.print(s.substring(j, i + j) + ", ");
            }
        }
	}

}
