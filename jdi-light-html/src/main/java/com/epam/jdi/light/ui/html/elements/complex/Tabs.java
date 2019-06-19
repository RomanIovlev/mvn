package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.tools.func.JFunc1;

import java.util.List;

import static com.epam.jdi.light.elements.base.JDIBase.waitCondition;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Tabs extends UIListBase<UISelectAssert> {
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) { list().select(value); }
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) { list().select(index);  }

    @JDIAction("Get selected value")
    public String selected() { return list().selected(); }
    @JDIAction("Is '{0}' selected")
    public boolean selected(String value) { return list().selected(value); }

    @JDIAction(level = DEBUG)
    public List<String> values() {
        return list().values();
    }
    @JDIAction(level = DEBUG)
    public List<String> innerValues() {
        return list().innerValues();
    }
    @JDIAction(level = DEBUG)
    public List<String> listEnabled() { return list().listEnabled(); }

    @JDIAction(level = DEBUG)
    public List<String> listDisabled() { return list().listDisabled();
    }
    public boolean wait(JFunc1<Tabs, Boolean> condition) {
        return waitCondition(condition, this);
    }

    @JDIAction("Hover to '{name}'")
    public void hover() {
        list().hover();
    }
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return list().isDisplayed();
    }
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return list().isHidden();
    }
    @JDIAction(level = DEBUG)
    public void highlight(String color) {
        list().highlight(color);
    }
    @JDIAction(level = DEBUG)
    public void highlight() {
        list().highlight();
    }
    @JDIAction(level = DEBUG)
    public void show() {
        list().show();
    }
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return list().listEnabled().size() > 0;
    }
}
