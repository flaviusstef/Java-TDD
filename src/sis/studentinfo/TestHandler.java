package sis.studentinfo;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TestHandler extends Handler {

	private LogRecord record;

	@Override
	public void close() throws SecurityException { }

	@Override
	public void flush() { }

	@Override
	public void publish(LogRecord record) {
		this.record = record;
	}
	
	String getMessage() {
		return record.getMessage();
	}
}