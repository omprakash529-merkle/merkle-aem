const { defineConfig } = require('cypress');
module.exports = defineConfig({
  e2e: {
    baseUrl: process.env.AEM_PUBLISH_URL || 'http://localhost:4503',
    specPattern: 'cypress/e2e/**/*.cy.js',
    supportFile: false,
  },
});
