package com.finalback;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UscApplicationTests {

	@Test
	void contextLoads() {
		test1 temp = new test1();
		Assertions.assertEquals(6, temp.mult(2, 3));
	}

	@Test
	void contextLoads2() {
		test1 temp2 = new test1();
		Assertions.assertFalse(temp2.ad("asdfvasdf", "astqqvvasdf"));
	}

	class test1{
		private int a;
		private int b;
		String x;
		String y;

		public int mult(int a, int b){
			return a * b;
		}



		public boolean ad(String x, String y) {
			return (x + y).length() < 10;
		}
	}

}
