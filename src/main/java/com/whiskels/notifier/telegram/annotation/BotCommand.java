package com.whiskels.notifier.telegram.annotation;

import com.whiskels.notifier.telegram.Command;
import com.whiskels.notifier.telegram.domain.Role;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.whiskels.notifier.telegram.domain.Role.UNAUTHORIZED;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Indicates that a component is a valid handler for bot command
 * <p>
 * Used on inheritors of {@link com.whiskels.notifier.telegram.handler.AbstractBaseHandler}
 *
 * @see DebtHandler example of implementation
 */

@Profile("telegram-common")
@Component
@Retention(RUNTIME)
@Target(TYPE)
public @interface BotCommand {
    /**
     * Returns an array of the commands supported by handler
     *
     * @return an array of the commands supported by handler
     */
    Command[] command();

    /**
     * Returns an array of user roles that have access to the handler
     * Default: {@link Role#UNAUTHORIZED} - every user can call this handler
     *
     * @return an array of user roles that have access to the handler
     */
    Role[] requiredRoles() default UNAUTHORIZED;
}
