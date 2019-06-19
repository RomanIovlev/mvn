package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.aserts.RangeAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static com.epam.jdi.light.ui.html.HtmlUtils.parseInt;

public class Range extends UIBaseElement<RangeAssert> implements WithLabel, SetValue {

    // region Actions
    @JDIAction(value = "Get '{name}' volume", level = DEBUG)
    public int volume() {
        return getInt("value", element);
    }

    @JDIAction(value = "Get '{name}' min limit", level = DEBUG)
    public String min() { return element.attr("min"); }

    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public String max() { return element.attr("max"); }

    @JDIAction(value = "Get '{name}' step size", level = DEBUG)
    public String step() { return element.attr("step"); }

    @JDIAction(value = "Set volume '{0}' for '{name}'", level = DEBUG)
    public void setVolume(int volume) {
        setValue(volume+"");
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        setVolume(parseInt(value));
    }
    public String getValue() {
        return volume()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public RangeAssert is() {
        return new RangeAssert().set(this);
    }
    // endregion
}
