package com.merkle.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

/**
 * Sling Model backing the Hello World component.
 * Reads an authored "message" property and exposes the current page title.
 */
@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HelloWorldModel {

    @Self
    private Resource resource;

    @ValueMapValue
    private String message;

    private String pageTitle;

    @PostConstruct
    protected void init() {
        if (resource != null) {
            PageManager pageManager = resource.getResourceResolver().adaptTo(PageManager.class);
            if (pageManager != null) {
                Page currentPage = pageManager.getContainingPage(resource);
                if (currentPage != null) {
                    pageTitle = currentPage.getTitle();
                }
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public String getPageTitle() {
        return pageTitle;
    }
}
