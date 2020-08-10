/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.context.event;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * Default {@link EventListenerFactory} implementation that supports the regular
 * {@link EventListener} annotation.
 *
 * <p>
 * DefaultEventListenerFactory --- springContext自己注入的
 * TransactionalEventListenerFactory -- 使用配置进去的
 * 
 * Used as "catch-all" implementation by default. 找到其中标注了 @EventListener
 * 的方法，利用反射和 DefaultEventListenerFactory 为其创建 ApplicationListener，并添加到事件派发器的缓存中
 * http://ddrv.cn/a/57277 处理事件监听的
 * 
 * 
 * @EventListener标注的方法被DefaultEventListenerFactory包装成ApplicationListenerMethodApdapter
 * 
 * @EventListener中的classes就是事件对象
 * ApplicationListenerMethodApdapter注册到ApplicationContext中。
 * 等待是事件源发布通知
 * 通知后执行的逻辑就是标注@EventListener的方法的逻辑
 * 
 * @author Stephane Nicoll
 * @since 4.2
 */
public class DefaultEventListenerFactory implements EventListenerFactory, Ordered {

	private int order = LOWEST_PRECEDENCE;

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int getOrder() {
		return this.order;
	}

	public boolean supportsMethod(Method method) {
		return true;
	}

	@Override
	public ApplicationListener<?> createApplicationListener(String beanName, Class<?> type, Method method) {
		return new ApplicationListenerMethodAdapter(beanName, type, method);
	}

}
