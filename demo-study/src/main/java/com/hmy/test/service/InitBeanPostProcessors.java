package com.hmy.test.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
@Component
public class InitBeanPostProcessors implements BeanPostProcessor {

	/**
	 * Apply this BeanPostProcessor to the given new bean instance <i>before</i> any
	 * bean initialization callbacks (like InitializingBean's
	 * {@code afterPropertiesSet} or a custom init-method). The bean will already be
	 * populated with property values. The returned bean instance may be a wrapper
	 * around the original.
	 * <p>
	 * The default implementation returns the given {@code bean} as-is.
	 * 
	 * @param bean     the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one; if
	 *         {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 */
	@Nullable
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization");
		return bean;
	}

	/**
	 * Apply this BeanPostProcessor to the given new bean instance <i>after</i> any
	 * bean initialization callbacks (like InitializingBean's
	 * {@code afterPropertiesSet} or a custom init-method). The bean will already be
	 * populated with property values. The returned bean instance may be a wrapper
	 * around the original.
	 * <p>
	 * In case of a FactoryBean, this callback will be invoked for both the
	 * FactoryBean instance and the objects created by the FactoryBean (as of Spring
	 * 2.0). The post-processor can decide whether to apply to either the
	 * FactoryBean or created objects or both through corresponding
	 * {@code bean instanceof FactoryBean} checks.
	 * <p>
	 * This callback will also be invoked after a short-circuiting triggered by a
	 * {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation}
	 * method, in contrast to all other BeanPostProcessor callbacks.
	 * <p>
	 * The default implementation returns the given {@code bean} as-is.
	 * 
	 * @param bean     the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one; if
	 *         {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 * @see org.springframework.beans.factory.FactoryBean
	 */

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization");
		return bean;
	}
}
