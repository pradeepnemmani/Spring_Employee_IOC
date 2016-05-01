package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by deep's on 5/1/2016.
 */
@Aspect
public class EmployeeLogging {
    public EmployeeLogging() {
        System.out.println("------------------Employee Logging Aspect Created------------------------");

    }
    @Pointcut(value = "@annotation(annotation.Logging)")
    public void beforeAnnotate()
    {
    }

    @Before(value = "beforeAnnotate()")
    public void logEntry(JoinPoint joinPoint) {
        Long entryTime = System.currentTimeMillis();
        System.out.println("Entering " + joinPoint.getSignature()+ "entryTime In milliseconds==" + entryTime);
    }
}

