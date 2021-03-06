/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.config.model.transform;

import java.util.Map;
import java.util.Map.Entry;

import com.amazonaws.services.config.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * Config Rule JSON Unmarshaller
 */
public class ConfigRuleJsonUnmarshaller implements Unmarshaller<ConfigRule, JsonUnmarshallerContext> {

    public ConfigRule unmarshall(JsonUnmarshallerContext context) throws Exception {
        ConfigRule configRule = new ConfigRule();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();
        if (token == VALUE_NULL) return null;

        while (true) {
            if (token == null) break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("ConfigRuleName", targetDepth)) {
                    context.nextToken();
                    configRule.setConfigRuleName(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("ConfigRuleArn", targetDepth)) {
                    context.nextToken();
                    configRule.setConfigRuleArn(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("ConfigRuleId", targetDepth)) {
                    context.nextToken();
                    configRule.setConfigRuleId(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("Description", targetDepth)) {
                    context.nextToken();
                    configRule.setDescription(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("Scope", targetDepth)) {
                    context.nextToken();
                    configRule.setScope(ScopeJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("Source", targetDepth)) {
                    context.nextToken();
                    configRule.setSource(SourceJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("InputParameters", targetDepth)) {
                    context.nextToken();
                    configRule.setInputParameters(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("MaximumExecutionFrequency", targetDepth)) {
                    context.nextToken();
                    configRule.setMaximumExecutionFrequency(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("ConfigRuleState", targetDepth)) {
                    context.nextToken();
                    configRule.setConfigRuleState(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth) break;
                }
            }

            token = context.nextToken();
        }
        
        return configRule;
    }

    private static ConfigRuleJsonUnmarshaller instance;
    public static ConfigRuleJsonUnmarshaller getInstance() {
        if (instance == null) instance = new ConfigRuleJsonUnmarshaller();
        return instance;
    }
}
    