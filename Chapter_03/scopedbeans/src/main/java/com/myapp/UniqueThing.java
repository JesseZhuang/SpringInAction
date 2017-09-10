package com.myapp;

import org.springframework.stereotype.Component;

/**
 * By default, all beans created in the Spring application context are created as single- tons.
 * <ul>
 *     <li>Singleton—One instance of the bean is created for the entire application</li>
 *     <li>Prototype—One instance of the bean is created every time the bean is injected
 *      into or retrieved from the Spring application context.</li>
 *     <li>Session —In a web application, one instance of the bean is created for each session.</li>
 *     <li>Request—In a web application, one instance of the bean is created for each request.</li>
 * </ul>
 */
@Component
public class UniqueThing {
  // the details of this class are inconsequential to this example
}
