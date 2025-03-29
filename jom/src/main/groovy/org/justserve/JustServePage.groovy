package org.justserve

import geb.Page
import org.openqa.selenium.By

/**
 * Parent Object Model for JustServe Pages
 */
class JustServePage extends Page{
    static content = {
        header { module(HeaderModule)}
    }
    static at = {
        waitFor{
            title.equalsIgnoreCase("JustServe")
        }
    }
}
