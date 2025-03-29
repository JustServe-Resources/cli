package org.justserve

import geb.Page

class AboutUsPage extends Page{
    static at = { title.contains("About Us - JustServe") }
    static content = {
        header { module(HeaderModule)}
    }
}
