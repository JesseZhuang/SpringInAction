package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * <p>
 * Spring’s support for AOP comes in four styles:
 *  Classic Spring proxy-based AOP
 *  Pure-POJO aspects
 *  @AspectJ annotation-driven aspects
 *  Injected AspectJ aspects (available in all versions of Spring)
 * The first three styles are all variations on Spring’s own AOP implementation. Spring AOP is built around
 * dynamic proxies. Consequently, Spring’s AOP support is limited to method interception.
 * </p>
 * <p>
 * It’s important to understand that Spring’s AspectJ auto-proxying only uses @AspectJ annotations as a guide for
 * creating proxy-based aspects. Under the covers, it’s still Spring’s proxy-based aspects.
 * This is significant because it means that although you’re using @AspectJ annotations, you’re still limited to
 * proxying method invocations. If you want to be able to exploit the full power of AspectJ, you’ll have to use
 * the AspectJ runtime and not rely on Spring to create proxy-based aspects.
 * <p>
 * Compile time: Aspects are woven in when the target class is compiled. This requires a special compiler.
 * AspectJ’s weaving compiler weaves aspects this way.
 * <p>
 * Class load time: Aspects are woven in when the target class is loaded into the JVM. This requires a special
 * ClassLoader that enhances the target class’s bytecode before the class is introduced into the application.
 * AspectJ 5’s load-time weaving (LTW) support weaves aspects this way.
 * <p>
 * Runtime—Aspects are woven in sometime during the execution of the applica- tion. Typically, an AOP container
 * dynamically generates a proxy object that del- egates to the target object while weaving in the aspects.
 * This is how Spring AOP aspects are woven.
 */
@Aspect
public class Audience {

    /**
     * define named pointcut. marker method with empty body.
     */
    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance() {
    }

    /**
     * pointcut definition
     * execution(), triggers on execution
     * * returning any type
     * .. take any arguments
     */
    @Before("execution(** concert.Performance.perform(..))")
    public void silentCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    /**
     * after bad peformance
     */
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    /**
     * What’s also interesting is that just as you can omit a call to the proceed() method to block access to the
     * advised method, you can also invoke it multiple times from within the advice. One reason for doing this may be
     * to implement retry logic to per- form repeated attempts on the advised method should it fail.
     * @param jp joint point method
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            // invoke the advised method
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
