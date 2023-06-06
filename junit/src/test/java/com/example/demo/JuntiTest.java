package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class JuntiTest {

	Product prod = new Product();
	int price = 5000;
	int saleRate = 10;
	static List<Integer> user = new ArrayList<Integer>();

	// 현재 클래스를 실행하기 전 제일 먼저 실행할 테스트 작성하는데, static로 선언함.
	@BeforeAll
	public static void setupAll() {
		user.add(1);
		user.add(2);
	}

	// 모든 테스트 실행 전에 실행할 테스트에 사용함.
	@BeforeEach
	public void setup() {
		prod.setPrice(price);
		prod.setSaleRate(saleRate);
	}

	@Test
	@Timeout(1000)
	@DisplayName("poduct price")
	public void originalPrice() throws Exception {
		// 값이 같은지 확인
		assertEquals(prod.getPrice(), price);
	}

	@Test
	@Disabled
	@DisplayName("listCheck value")
	public void listCheck() throws Exception {
		List<Integer> userTest = new ArrayList<Integer>();
		userTest.add(1);
		userTest.add(2);
		// 값이 같은지 확인 배열도 사용가능
		assertEquals(user, userTest);
	}

	@Test
	@DisplayName("listCheck isSame")
	public void listCheckSame() throws Exception {
		List<Integer> userTest = new ArrayList<Integer>();
		userTest.add(1);
		userTest.add(2);
		// 객체의 주소값이 다른지 확인 
		assertNotSame(user,userTest);
		// 객체의 주소값이 같은지 확인
		assertSame(user, userTest);
	}

	@Test
	void testAssertThrows() {
		assertThrows(ArithmeticException.class, () -> {
			int i = 1 / 0;
		});
	}

	@Test
	void assertAlls() {
		String nullTest = null;
		// JUnit5에서 새로 도입된 Assertion 구문.
		assertAll("heading", () -> assertEquals(100, 10 * 10), () -> assertEquals("java", "JAVA".toLowerCase()),
				() -> assertNull(nullTest, "obj is null"));
	}

	@Test
	void nullTest() {
		Optional<Integer> option = Optional.ofNullable(null);
		Integer testPrice = option.orElseGet(() -> {
			Integer testVal = null;
			return testVal;
		});

		
		assertNull(testPrice, () -> "The java should not be null");

		Object python = new Object();

		assertNotNull(python, () -> "The python should not be null");
	}

	// 모든 테스트 실행 후에 실행한 테스트에 사용함.
	@AfterEach
	public void disable() {
		prod = new Product();
	}

	// 현재 클래스 종료 후 해당 테스트를 실행하는데, static으로 선언함.
	@AfterAll
	public static void disableAll() {
		user = new ArrayList<Integer>();
	}

}
