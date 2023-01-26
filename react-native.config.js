const path = require('path');

module.exports = {
  dependencies: {
    'sample-native-module': {
      root: path.resolve(__dirname, './sample-native-module'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-module/android'),
        },
      },
    },
  },
};
