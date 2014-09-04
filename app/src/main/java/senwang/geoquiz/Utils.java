package senwang.geoquiz;

public class Utils {

	public static final String getTag() {
		StackTraceElement callerStackTraceElement = Thread.currentThread().getStackTrace()[3];
		String fullClassName = callerStackTraceElement.getClassName();
		String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		String methodName = callerStackTraceElement.getMethodName();
		int lineNumber = callerStackTraceElement.getLineNumber();
		return className + "." + methodName + "-" + lineNumber;
	}
}
