package io.github.simplex.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Info {
    String name();
    String description();
    String usage();
    String permission();
    String aliases() default "";
    String permissionMessage() default "You do not have permission to use this command.";
}
