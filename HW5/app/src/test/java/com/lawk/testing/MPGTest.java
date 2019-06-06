package com.lawk.testing;
import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;


public class MPGTest {

    MPG mpgTest;

    @Mock
    Context mockContext;

    @Before
    public void setUp(){
        this.mpgTest = new MPG(20, 50);

        MockitoAnnotations.initMocks(this);

        when(mockContext.getString(R.string.miles)).thenReturn("100");
        when(mockContext.getString(R.string.mpg)).thenReturn("25");

    }

    @Test
    public void mpgCalculateCost_ReturnsCorrect() {
        double unleadedCostCorrect = mpgTest.calculateCost("Unleaded");
        assertThat(unleadedCostCorrect).isEqualTo(1.54);

        double plusCostCorrect = mpgTest.calculateCost("Plus");
        assertThat(plusCostCorrect).isEqualTo(1.58);

        double premiumCostCorrect = mpgTest.calculateCost("Premium");
        assertThat(premiumCostCorrect).isEqualTo(1.62);

    }

    @Test
    public void mpgDefault_ReturnsCorrect() {
        MPG defaultMPG = new MPG(mockContext);
        double defaultUnleadedCostCorrect = defaultMPG.calculateCost("Unleaded");
        assertThat(defaultUnleadedCostCorrect).isEqualTo(15.4);
    }

    @After
    public void tearDown() {

    }

}
