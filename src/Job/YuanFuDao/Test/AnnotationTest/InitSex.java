package Job.YuanFuDao.Test.AnnotationTest;

import java.lang.annotation.*;

/**
 * 性别赋值校验
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface InitSex {
    enum Sex {MAN,WOMAN};
    Sex sex() default Sex.MAN;
}
