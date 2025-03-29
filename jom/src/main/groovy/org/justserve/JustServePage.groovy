package org.justserve

import geb.Page

/**
 * Parent Object Model for JustServe Pages
 */
class JustServePage extends Page{
    static url = {
        System.getenv("JUSTSERVE_ENV") != null ? "https://dev.justserve.org" : "https://justserve.org"
    }

    static content = {
        header { module(HeaderModule)}
    }
}
