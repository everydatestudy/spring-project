/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * A single {@code condition} that must be {@linkplain #matches matched} in
 * order for a component to be registered.
 *
 * <p>
 * Conditions are checked immediately before the bean-definition is due to be
 * registered and are free to veto registration based on any criteria that can
 * be determined at that point.
 *
 * <p>
 * Conditions must follow the same restrictions as
 * {@link BeanFactoryPostProcessor} and take care to never interact with bean
 * instances. For more fine-grained control of conditions that interact with
 * {@code @Configuration} beans consider the {@link ConfigurationCondition}
 * interface.
 *
 * @author Phillip Webb
 * @since 4.0
 * @see ConfigurationCondition
 * @see Conditional
 * @see ConditionContext
 */
@FunctionalInterface
public interface Condition {

	/**
	 * Condition接口主要有一个matches方法，该方法决定了是否要注册相应的bean对象。
	 * 其中matches方法中有两个参数，参数类型分别是ConditionContext和AnnotatedTypeMetadata，
	 * 这两个参数非常重要。它们分别用来获取一些环境信息和注解元数据从而用在matches方法中判断是否符合条件。
	 * 
	 * ConditionContext，顾名思义，主要是跟Condition的上下文有关，
	 * 主要用来获取Registry,BeanFactory,Environment,ResourceLoader和ClassLoader等。
	 * 那么获取这些用来干什么呢？举个栗子，
	 * 比如OnResourceCondition需要靠ConditionContext来获取ResourceLoader来加载指定资源，
	 * OnClassCondition需要靠ConditionContext来获取ClassLoader来加载指定类等，下面看下其源码：
	 * 
	 * Determine if the condition matches.
	 * 
	 * @param context  the condition context
	 * @param metadata metadata of the
	 *                 {@link org.springframework.core.type.AnnotationMetadata
	 *                 class} or {@link org.springframework.core.type.MethodMetadata
	 *                 method} being checked
	 * @return {@code true} if the condition matches and the component can be
	 *         registered, or {@code false} to veto the annotated component's
	 *         registration
	 */
	boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);

}
