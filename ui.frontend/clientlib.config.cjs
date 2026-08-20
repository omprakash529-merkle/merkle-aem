const path = require('path');
module.exports = {
  context: path.resolve(__dirname, 'dist'),
  clientLibRoot: path.resolve(
    __dirname,
    '../ui.apps/src/main/content/jcr_root/apps/merkle/clientlibs'
  ),
  libs: [
    {
      name: 'clientlib-site',
      categories: ['merkle.site'],
      serializationFormat: 'xml',
      assets: {
        js: ['clientlib-site/site.js'],
        css: ['clientlib-site/site.css'],
      },
    },
  ],
};
