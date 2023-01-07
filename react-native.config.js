const path = require('path');

module.exports = {
  dependencies: {
    samplenativemodule: {
      root: path.resolve(__dirname, './SampleNativeModule'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './SampleNativeModule/android'),
        },
      },
    },
  },
};
