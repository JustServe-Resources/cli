package org.justserve

import geb.Page

/**
 * Page object for justserve.org/organizations
 */
class OrganizationsPage extends Page{
    static at = { title.contains("Organizations - JustServe") }
    static content = {
        header { module(HeaderModule)}
    }
}
