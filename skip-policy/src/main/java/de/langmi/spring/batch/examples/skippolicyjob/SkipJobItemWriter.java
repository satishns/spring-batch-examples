/*
 * Copyright 2011 Michael R. Lange.
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
package de.langmi.spring.batch.examples.skippolicyjob;

import java.util.List;
import org.springframework.batch.item.ItemWriter;

/**
 * SkipJobItemWriter.
 *
 * @author Michael R. Lange <michael.r.lange@langmi.de>
 */
public class SkipJobItemWriter implements ItemWriter<String> {

    /** {@inheritDoc} */
    @Override
    public void write(List<? extends String> items) throws Exception {
        for (String item : items) {
            // throw exception for specific items
            if (Integer.valueOf(item) == 5 || Integer.valueOf(item) == 16) {
                throw new SkipJobCustomException("provoked error with:" + item);
            }
        }
    }
}