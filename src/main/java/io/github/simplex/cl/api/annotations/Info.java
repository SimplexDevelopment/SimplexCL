package io.github.simplex.cl.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Info {
    /**
     * @return The name of the command.
     */
    String name();

    /**
     * @return The description of the command.
     */
    String description();

    /**
     * @return The proper usage of the command.
     */
    String usage();

    /**
     * @return The aliases for the command, separated by commas (alias1,alias2,alias3)
     */
    String aliases() default "";
}
