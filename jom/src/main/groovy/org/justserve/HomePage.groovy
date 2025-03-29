package org.justserve

import geb.Page

/**
 * Page object for justserve.org
 */
class HomePage extends Page{
    static content = {
        header { module(HeaderModule)}
    }
}
