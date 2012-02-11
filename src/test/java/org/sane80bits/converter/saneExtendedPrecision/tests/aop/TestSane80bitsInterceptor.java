package org.sane80bits.converter.saneExtendedPrecision.tests.aop;

import org.jboss.aop.joinpoint.Invocation;
import org.jboss.aop.joinpoint.MethodInvocation;
import org.testng.Reporter;

public class TestSane80bitsInterceptor implements org.jboss.aop.advice.Interceptor {
	public Object invoke(Invocation invocation) throws Throwable {
		java.lang.reflect.Method m = ((MethodInvocation) invocation).getMethod();
		String msg = "=> " + m.getName();
		System.out.println(msg);
		Reporter.log(msg);
		long startTime = System.currentTimeMillis();
		try {
			return invocation.invokeNext();
		} finally {
			long endTime = System.currentTimeMillis() - startTime;
			msg = "=< " + m.getName() + " time: " + endTime
					+ "ms";
			System.out.println(msg);
			Reporter.log(msg);
		}
	}

	public String getName() {
		return this.toString();
	}
}
