package aspect;

/**
 * Created by mani's on 5/1/2016.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

public class EmployeeAspect {
    public EmployeeAspect() {
        System.out.println("**************** Aspect Bean Created*****************");
    }
    public void logEntry(JoinPoint joinPoint) {
        Long entryTime = System.currentTimeMillis();
        System.out.println("Entering " + joinPoint.getSignature()+ "entryTime In milliseconds==" + entryTime);
    }

    public Object timeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long entryTime = System.currentTimeMillis();
        Object o = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();

        System.out.println("Execution of method - " + proceedingJoinPoint.getSignature() + " took - " + (endTime - entryTime) + " milliseconds.");

        return o;
    }
}
