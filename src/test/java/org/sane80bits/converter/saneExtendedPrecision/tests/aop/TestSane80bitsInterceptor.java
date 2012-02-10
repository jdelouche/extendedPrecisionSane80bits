package org.sane80bits.converter.saneExtendedPrecision.tests.aop;

import org.jboss.aop.joinpoint.Invocation;
import org.jboss.aop.joinpoint.MethodInvocation;

public class TestSane80bitsInterceptor implements org.jboss.aop.advice.Interceptor {
	public Object invoke(Invocation invocation) throws Throwable {
		java.lang.reflect.Method m = ((MethodInvocation) invocation).getMethod();
		System.out.println("=> " + m.getName());
		long startTime = System.currentTimeMillis();
		try {
			return invocation.invokeNext();
		} finally {
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println("=< " + m.getName() + " time: " + endTime
					+ "ms");
		}
	}

	public String getName() {
		return this.toString();
	}
}
