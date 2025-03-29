package org.justserve

import geb.Page

/**
 * Page object for justserve.org/stories
 */
class SuccessStoriesPage extends Page{
    static at = { title.contains("Success Stories - JustServe") }
    static content = {
        header { module(HeaderModule)}
    }
}
