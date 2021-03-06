/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.bxbot.domain.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Tests a StrategyConfig domain object behaves as expected.
 *
 * @author gazbert
 */
public class TestStrategyConfig {

  private static final String ID = "macd-long-position";
  private static final String LABEL = "MACD Long Position Algo";
  private static final String DESCRIPTION =
      "Uses MACD as indicator and takes long position in base currency.";
  private static final String CLASSNAME = "com.gazbert.nova.algos.MacdLongBase";
  private static final String BEAN_NAME = "macdLongBase";
  private static final Map<String, String> CONFIG_ITEMS = new HashMap<>();

  @Test
  public void testInitialisationWorksAsExpected() {
    final StrategyConfig strategyConfig =
        new StrategyConfig(ID, LABEL, DESCRIPTION, CLASSNAME, BEAN_NAME, CONFIG_ITEMS);
    assertEquals(ID, strategyConfig.getId());
    assertEquals(LABEL, strategyConfig.getName());
    assertEquals(DESCRIPTION, strategyConfig.getDescription());
    assertEquals(CLASSNAME, strategyConfig.getClassName());
    assertEquals(CONFIG_ITEMS, strategyConfig.getConfigItems());
  }

  @Test
  public void testSettersWorkAsExpected() {
    final StrategyConfig strategyConfig = new StrategyConfig();
    assertNull(strategyConfig.getId());
    assertNull(strategyConfig.getName());
    assertNull(strategyConfig.getDescription());
    assertNull(strategyConfig.getClassName());
    assertTrue(strategyConfig.getConfigItems().isEmpty());

    strategyConfig.setId(ID);
    assertEquals(ID, strategyConfig.getId());

    strategyConfig.setName(LABEL);
    assertEquals(LABEL, strategyConfig.getName());

    strategyConfig.setDescription(DESCRIPTION);
    assertEquals(DESCRIPTION, strategyConfig.getDescription());

    strategyConfig.setClassName(CLASSNAME);
    assertEquals(CLASSNAME, strategyConfig.getClassName());

    strategyConfig.setBeanName(BEAN_NAME);
    assertEquals(BEAN_NAME, strategyConfig.getBeanName());

    strategyConfig.setConfigItems(CONFIG_ITEMS);
    assertEquals(CONFIG_ITEMS, strategyConfig.getConfigItems());
  }

  @Test
  public void testCloningWorksAsExpected() {
    final StrategyConfig strategyConfig =
        new StrategyConfig(ID, LABEL, DESCRIPTION, CLASSNAME, BEAN_NAME, CONFIG_ITEMS);
    final StrategyConfig clonedStrategyConfig = new StrategyConfig(strategyConfig);
    assertEquals(clonedStrategyConfig, strategyConfig);
  }

  @Test
  public void testEqualsWorksAsExpected() {
    final StrategyConfig strategy1 =
        new StrategyConfig(ID, LABEL, DESCRIPTION, CLASSNAME, BEAN_NAME, CONFIG_ITEMS);
    final StrategyConfig strategy2 =
        new StrategyConfig("different-id", LABEL, DESCRIPTION, CLASSNAME, BEAN_NAME, CONFIG_ITEMS);
    assertEquals(strategy1, strategy1);
    assertNotEquals(strategy1, strategy2);
  }
}
