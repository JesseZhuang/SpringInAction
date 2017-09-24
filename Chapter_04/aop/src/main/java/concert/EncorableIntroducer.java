package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * It introduces the Encoreable interface to Performance beans using the @DeclareParents annotation.
 * When Spring discovers a bean annotated with @Aspect, it will automatically create a proxy that delegates calls
 * to either the proxied bean or to the introduction implementation, depending on whether the method called belongs
 * to the proxied bean or to the introduced interface.
 * <p>
 * But annotation-oriented aspect declaration has one clear disadvantage: you must be able to annotate the advice
 * class. And to do that, you must have the source code.
 */
@Aspect
public class EncorableIntroducer {
    /**
     * The plus sign at the end specifies any subtype of Performance.
     */
    @DeclareParents(value = "concert.Performance+",
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
