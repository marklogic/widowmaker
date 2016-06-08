/*
 * Copyright 2003-2013 MarkLogic Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.stress;

import java.util.ArrayList;
import java.util.List;

public class BulkQueryTester extends RestQueryTester {

    public BulkQueryTester(ConnectionData connData, QueryTestData loadData,
            String threadName, String iterationName) {
        super(connData, loadData, threadName, iterationName);
        //System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.wire", "debug");
    }

    @Override
    public void runQueries(int number, String collection) {
        message("Bulk Querying...");
        int count = getSession().searchBulk("future", collection, null);
        verifyQuery("bulk search", number, count, collection);
    }

}
