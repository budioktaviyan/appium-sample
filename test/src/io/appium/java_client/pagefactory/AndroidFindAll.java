package io.appium.java_client.pagefactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to mark a field on a Page/Screen Object to indicate that lookup should use a series of {@link AndroidFindBy} tags
 * It will then search for all elements that match any criteria. Note that elements
 * are not guaranteed to be in document order.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface AndroidFindAll {
	AndroidFindBy[] value();
}
