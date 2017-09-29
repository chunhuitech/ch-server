package cn.chunhuitech.www.core.common.annotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by hechengjin on 17-9-29.
 */
@Target({TYPE, FIELD, METHOD})
public @interface NotNull {
    String message() default "";
}

