

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.gridy.utils;


/**
 * An interface for database ID generators.
 *
 * @author Sebastian Schaffert (sschaffert@apache.org)
 */
public interface IDGenerator {

    /**
     * Return the next unique id for the type with the given name using the generator's id generation strategy.
     * @return
     */
    long getId();
    
    String getIdStr();

    /**
     * Shut down this id generator, performing any cleanups that might be necessary.
     *
     */
    void shutdown();
}
