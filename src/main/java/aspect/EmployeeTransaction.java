package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by deep's on 5/1/2016.
 */
@Aspect
public class EmployeeTransaction {
    public EmployeeTransaction() {
        System.out.println("---------------Employee Transaction Bean created------------------------");
    }

    @Pointcut(value = "@annotation(annotation.Transactional)")
    public void aroundAnnotate()
    {
    }

    @Around(value = "aroundAnnotate()")
    public Object timeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long entryTime = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        System.out.println("Execution of method - " + proceedingJoinPoint.getSignature() + " took - " + (endTime - entryTime) + " milliseconds.");

        return object;
    }
}
