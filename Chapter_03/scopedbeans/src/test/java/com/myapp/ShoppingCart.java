package com.myapp;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * As configured, proxyMode is set to ScopedProxyMode.INTERFACES, indicat- ing that the proxy should implement
 * the ShoppingCart interface and delegate to the implementation bean.
 * <p>
 * If the bean type is a concrete class, you must set proxyMode to ScopedProxy- Mode.TARGET_CLASS
 * to indicate that the proxy should be generated as an extension of the target class.
 */
@Component
@Scope(
        value= WebApplicationContext.SCOPE_SESSION,
        proxyMode= ScopedProxyMode.INTERFACES)
public interface ShoppingCart {  }
