package org.justserve

import geb.Module

/**
 * Header Module
 */
class HeaderModule extends Module{
    static content = {
        headerLogo { $("a.js-logo-link")}
        headerProjects { $("a", class: "header-link", text: "Projects") }
        headerOrganizations { $("a", class: "header-link", text: "Organizations") }
        headerSuccessStories { $("a", class: "header-link", text: "Success Stories") }
        headerAboutUs { $("a", class: "header-link", text: "About Us") }
    }

    /**
     * Clicks the About Us link in the header.
     * @return a new instance of the AboutUsPage
     */
    AboutUsPage clickAboutUs() {
        headerAboutUs.click()
        return new AboutUsPage()
    }

    /**
     * Clicks the Projects link in the header.
     * @return a new instance of the ProjectsPage
     */
    ProjectsPage clickProjects() {
        headerProjects.click()
        return new ProjectsPage()
    }

    /**
     * Clicks the Organizations link in the header.
     * @return a new instance of the OrganizationsPage
     */
    OrganizationsPage clickOrganizations() {
        headerOrganizations.click()
        return new OrganizationsPage()
    }

    /**
     * Clicks the Success Stories link in the header.
     * @return a new instance of the SuccessStoriesPage
     */
    SuccessStoriesPage clickSuccessStories() {
        headerSuccessStories.click()
        return new SuccessStoriesPage()
    }
}
