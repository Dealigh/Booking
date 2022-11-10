package com.qualitest.booking;

import com.qualitest.booking.utils.Time;
import com.qualitest.booking.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractTest {

    protected static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);

    protected Time time = new Time();

    protected Utils utils = new Utils();
}
