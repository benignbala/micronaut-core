/*
 * Copyright 2017 original authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.particleframework.context.scope;

import org.particleframework.inject.BeanDefinition;
import org.particleframework.inject.BeanIdentifier;

import javax.inject.Provider;
import java.lang.annotation.Annotation;
import java.util.Optional;


/**
 * Represents a custom scope within the {@link org.particleframework.context.BeanContext}
 *
 * @see javax.inject.Scope
 *
 * @author Graeme Rocher
 * @since 1.0
 */
public interface CustomScope<A extends Annotation> {

    /**
     * @return The scope annotation type
     */
    Class<A> annotationType();

    /**
     * Resolve an object from the given scope
     *
     * @param beanDefinition The bean definition
     * @param identifier The {@link BeanIdentifier}
     * @param provider The provider that will build the bean definition
     * @param <T> The bean generic type
     * @return The bean instance
     */
    <T> T get(BeanDefinition<T> beanDefinition, BeanIdentifier identifier, Provider<T> provider);

    /**
     * Remove a bean definition from the scope
     *
     * @param identifier The {@link BeanIdentifier}
     * @param <T> The generic type
     * @return An {@link Optional} of the instance if it exists
     */
    <T> Optional<T> remove(BeanIdentifier identifier);
}
