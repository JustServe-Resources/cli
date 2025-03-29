package org.justserve

import geb.Page

/**
 * Page object for justserve.org/projects
 */
class ProjectsPage extends Page{
    static at = { title.contains("Projects - JustServe") }
    static content = {
        header { module(HeaderModule)}
    }
}
