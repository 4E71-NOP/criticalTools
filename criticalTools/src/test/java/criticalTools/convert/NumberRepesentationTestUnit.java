package criticalTools.convert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.criticalTools.section.convert.NumberRepesentation;

class NumberRepesentationTestUnit {
	private int intDec = 15823;
	private NumberRepesentation nr = NumberRepesentation.getInstance();

	@Test
	void NumberRepesentationTestUnitDec2Bin() {
		assertEquals("11110111001111", nr.BaseConvertion(intDec, 2));
	}

	@Test
	void NumberRepesentationTestUnitDec2Tri() {
		assertEquals("210201001", nr.BaseConvertion(intDec, 3));
	}

	@Test
	void NumberRepesentationTestUnitDec2Qua() {
		assertEquals("3313033", nr.BaseConvertion(intDec, 4));
	}

	@Test
	void NumberRepesentationTestUnitDec2Qui() {
		assertEquals("1001243", nr.BaseConvertion(intDec, 5));
	}

	@Test
	void NumberRepesentationTestUnitDec2Sen() {
		assertEquals("201131", nr.BaseConvertion(intDec, 6));
	}

	@Test
	void NumberRepesentationTestUnitDec2Sep() {
		assertEquals("64063", nr.BaseConvertion(intDec, 7));
	}

	@Test
	void NumberRepesentationTestUnitDec2Oct() {
		assertEquals("36717", nr.BaseConvertion(intDec, 8));
	}

	@Test
	void NumberRepesentationTestUnitDec2Non() {
		assertEquals("23631", nr.BaseConvertion(intDec, 9));
	}

	@Test
	void NumberRepesentationTestUnitDec2UnD() {
		assertEquals("10985", nr.BaseConvertion(intDec, 11));
	}

	@Test
	void NumberRepesentationTestUnitDec2Doz() {
		assertEquals("91A7", nr.BaseConvertion(intDec, 12));
	}

	@Test
	void NumberRepesentationTestUnitDec2Hex() {
		assertEquals("3DCF", nr.BaseConvertion(intDec, 16));
	}

	
}
