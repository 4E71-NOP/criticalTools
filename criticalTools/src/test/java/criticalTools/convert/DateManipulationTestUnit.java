package criticalTools.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.criticalTools.section.convert.DateManipulation;

class DateManipulationTestUnit {
	private DateManipulation dm = DateManipulation.getInstance();
	private String dateOk = "2018-05-14";
	private String dateNok = "2018/05/14";
	private String timeOk = "22:13:14";
	private String dateTimeOk = dateOk + " " + timeOk;
	private String dateTimeNok = dateNok + " " + timeOk;
	private long timestampLong = 1526328794000l;

	// private Date d = new Date();
	private Timestamp t = Timestamp.valueOf(dateTimeOk);

	@Test
	void StringToTimestamp() {
		assertEquals(t, dm.StringToTimestamp(dateTimeNok));
	}

	@Test
	void TimestampToStringDate01() {
		assertEquals(dateOk, dm.TimestampToSimpleDateFormat(t, "yyyy-MM-dd"));
	}

	@Test
	void TimestampToStringDate02() {
		assertEquals(timeOk, dm.TimestampToSimpleDateFormat(t, "HH:mm:ss"));
	}

	@Test
	void TimestampToStringDate03() {
		assertEquals(dateOk + " 13", dm.TimestampToSimpleDateFormat(t, "yyyy-MM-dd mm"));
	}

	@Test
	void TimestampToStringDate04() {
		assertEquals(dateOk + " 14", dm.TimestampToSimpleDateFormat(t, "yyyy-MM-dd ss"));
	}

	@Test
	void TimestampToLongMillisecond() {
		assertEquals(timestampLong, dm.TimestampToLongMillisecond(t));
	}

	@Test
	void TimestampToLongSecond() {
		assertEquals((timestampLong / 1000), dm.TimestampToLongSecond(t));
	}

}
