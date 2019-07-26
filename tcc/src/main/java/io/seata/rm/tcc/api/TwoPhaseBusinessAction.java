/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.rm.tcc.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TCC annotation, Define a TCC interface，which added on the try method
 *
 * @author zhangsen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface TwoPhaseBusinessAction {

    /**
     * 从源码上看 TCCResourceManager | DataSourceManager 通过SPI 注册至 DefaultResourceManager
     * 而DefaultResourceManager是通过内部类实现的单例,
     * TCCResourceManager | DataSourceManager 内部使用ConcurrentHashMap做缓存, 因此 name 应用内应该是不允许重复的。
     * <p>
     * TCC bean name, must be unique
     *
     * @return the string
     */
    String name();

    /**
     * commit method name
     *
     * @return the string
     */
    String commitMethod() default "commit";

    /**
     * rollback method name
     *
     * @return the string
     */
    String rollbackMethod() default "rollback";

}