package com.merkle.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class HelloWorldModelTest {

    private final AemContext ctx = new AemContext();

    @BeforeEach
    void setUp() {
        ctx.addModelsForClasses(HelloWorldModel.class);
        ctx.create().page("/content/merkle", "/apps/merkle/templates/page", "Merkle Home");
        ctx.create().resource("/content/merkle/jcr:content/hello",
                "sling:resourceType", "merkle/components/helloworld",
                "message", "Hello from Merkle");
        ctx.currentResource("/content/merkle/jcr:content/hello");
    }

    @Test
    void exposesAuthoredMessage() {
        HelloWorldModel model = ctx.request().adaptTo(HelloWorldModel.class);
        assertEquals("Hello from Merkle", model.getMessage());
    }

    @Test
    void exposesContainingPageTitle() {
        Resource resource = ctx.currentResource();
        HelloWorldModel model = resource.adaptTo(HelloWorldModel.class);
        assertEquals("Merkle Home", model.getPageTitle());
    }
}
