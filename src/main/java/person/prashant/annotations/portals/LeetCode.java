package person.prashant.annotations.portals;

public @interface LeetCode {
    String url() default "";
    String questionNumber() default "";
}
