package com.project.chatconnect.utility;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;

/**
 * The type Application context utility.
 */
@Component
public class ApplicationContextUtility implements ApplicationContextAware, LoadTimeWeaverAware {

    private static ApplicationContext context;

    /**
     * Gets application context.
     *
     * @return the application context
     */
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     * Gets bean.
     *
     * @param <T>   the type parameter
     * @param clazz the clazz
     * @return the bean
     * @throws BeansException the beans exception
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return context.getBean(clazz);
    }

    /**
     * Gets bean by name.
     *
     * @param <T>      the type parameter
     * @param beanName the bean name
     * @param clazz    the clazz
     * @return the bean by name
     * @throws BeansException the beans exception
     */
    public static <T> T getBeanByName(String beanName, Class<T> clazz) throws BeansException {
        return context.getBean(beanName, clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        
    }
}
