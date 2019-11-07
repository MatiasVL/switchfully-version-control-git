package com.cegeka.steven.spring;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.notification.testbench.NotificationElement;
import com.vaadin.flow.theme.lumo.Lumo;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class MainViewIT extends AbstractViewTest {

    @Test
    public void clickingButtonShowsNotification() {
        assertFalse($(NotificationElement.class).exists());

        $(ButtonElement.class).first().click();

        assertTrue($(NotificationElement.class).waitForFirst().isOpen());
    }

    @Test
    public void clickingButtonTwiceShowsTwoNotifications() {
        assertFalse($(NotificationElement.class).exists());

        ButtonElement button = $(ButtonElement.class).first();
        button.click();
        button.click();

        assertEquals(2, $(NotificationElement.class).all().size());
    }

    @Test
    public void buttonIsUsingLumoTheme() {
        WebElement element = $(ButtonElement.class).first();
        assertThemePresentOnElement(element, Lumo.class);
    }
}
