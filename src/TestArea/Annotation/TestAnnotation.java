package TestArea.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)

public @interface TestAnnotation {
    String value() default "";
}
