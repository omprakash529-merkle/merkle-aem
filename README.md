# Merkle — AEM as a Cloud Service project

Sample AEMaaCS Maven project (archetype-style), scaffolded as a reference/starter.

- **groupId:** `com.merkle`
- **artifactId:** `merkle-aem`
- **appId:** `merkle`
- **Java:** 11 · **AEM:** Cloud Service (SDK API, not the 6.5 uber-jar)

## Modules

| Module | Package type | Purpose |
|--------|--------------|---------|
| `core` | OSGi bundle | Java — Sling Models, Servlets, Workflows |
| `ui.apps` | application | Immutable `/apps` — components (HTL), clientlibs |
| `ui.config` | application | OSGi run-mode configuration |
| `ui.content` | content | Mutable `/content`, `/conf` — sample page, templates |
| `ui.apps.structure` | container | Repository-structure package: owns the /apps + /conf filter roots |
| `ui.frontend` | jar | Webpack + TypeScript + SCSS build → `merkle.site` clientlib into ui.apps |
| `dispatcher` | pom/zip | AEMaaCS dispatcher.cloud config (vhosts, farms, filters, cache) |
| `it.tests` | jar | HTTP integration tests (failsafe, aem-cloud-testing-clients) |
| `ui.tests` | pom | End-to-end UI tests (Cypress) for the Cloud Manager UI-testing step |
| `all` | container | Embeds all deployable modules into one artifact |

## What's included as a reference
- `HelloWorldModel` — Sling Model (`@Model` on Resource, `@ValueMapValue`, `@Self`, `@PostConstruct`).
- `GreetingServlet` — path-bound GET servlet returning JSON (`/bin/merkle/greeting`).
- `helloworld` — HTL component (supers core `text` v2) + `data-sly-use` of the model.
- `HelloWorldModelTest` — JUnit 5 + AEM Mocks (`io.wcm.testing`) unit test.

## Build & deploy (your machine / CI — requires Maven + JDK 11)

```bash
# build all modules
mvn -B clean install

# build and deploy the container package to a local AEMaaCS SDK author
mvn -B clean install -PautoInstallSinglePackage

# deploy only the bundle (fast Java iteration)
mvn -B clean install -PautoInstallBundle -pl core
```

> Note: this project was scaffolded without a local Maven/JDK toolchain, so it has
> not been compiled here. Run `mvn clean install` in your environment to verify.
> Deployment to a real AEMaaCS instance goes through Cloud Manager Git + pipeline.

## AEMaaCS conventions honored
- SDK API dependency (`com.adobe.aem:aem-sdk-api`), not the 6.5 uber-jar.
- Immutable (`/apps`) vs mutable (`/content`, `/conf`) split across `ui.apps` / `ui.content`.
- `container` / `application` / `content` package types set explicitly.
- OSGi config as `.cfg.json` under `/apps/merkle/osgiconfig/config`.
