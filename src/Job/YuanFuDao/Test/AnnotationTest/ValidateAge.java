package Job.YuanFuDao.Test.AnnotationTest;

import java.lang.annotation.*;

/**
 * 年龄校验
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface ValidateAge {
    int min() default 18;
    int max() default 100;
    int value() default 20;
}
