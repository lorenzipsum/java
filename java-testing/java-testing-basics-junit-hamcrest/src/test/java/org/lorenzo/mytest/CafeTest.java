package org.lorenzo.mytest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;

public class CafeTest {

    public static final int NUMBER_OF_ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
    public static final int NUMBER_OF_LATTE_BEANS = CoffeeType.Latte.getRequiredBeans();
    public static final int NO_BEANS = 0;
    public static final int NO_MILK = 0;
    public static final int LATTE_MILK = CoffeeType.Latte.getRequiredMilk();

    private Cafe cafe;

    @Before
    public void before() {
        cafe = new Cafe();
    }


    @Test
    public void canBrewEspresso() {

        // 1 GIVEN
        withBeans();

        // 2 WHEN
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // 3 THEN
        assertThat(coffee, hasProperty("beans", equalTo(NUMBER_OF_ESPRESSO_BEANS)));
        assertThat(coffee, hasProperty("milk", equalTo(NO_MILK)));
        assertThat(coffee, hasProperty("type", equalTo(CoffeeType.Espresso)));
    }

    @Test
    public void canBrewLatte() {
        // given
        cafe.restockBeans(NUMBER_OF_LATTE_BEANS);
        cafe.restockMilk(LATTE_MILK);

        // when
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        // then
        assertThat(coffee,hasProperty("beans", equalTo(NUMBER_OF_LATTE_BEANS)));
        assertThat(coffee,hasProperty("milk", equalTo(LATTE_MILK)));
        assertThat(coffee,hasProperty("type", equalTo(CoffeeType.Latte)));
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // given
        withBeans();

        // when
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // then
        Assert.assertEquals(NO_BEANS, cafe.getBeansInStock());
        assertThat(cafe, hasProperty("beansInStock", equalTo(NO_BEANS)));
    }

    // then
    @Test(expected = IllegalStateException.class)
    public void latteRequiresMilk() {
        // given
        cafe.restockBeans(NUMBER_OF_LATTE_BEANS);

        // when
        cafe.brew(CoffeeType.Latte);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk() {
        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans() {
        cafe.restockBeans(NO_BEANS);
    }

    private void withBeans() {
        cafe.restockBeans(NUMBER_OF_ESPRESSO_BEANS);
    }
}

