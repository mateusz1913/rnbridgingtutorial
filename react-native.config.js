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
    'sample-native-module-classic': { // <--------- Add entry for "sample-native-module-classic"
      root: path.resolve(__dirname, './sample-native-module-classic'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-module-classic/android'),
        },
      },
    },
    'sample-native-datepicker': { // <--------- Add entry for "sample-native-datepicker"
      root: path.resolve(__dirname, './sample-native-datepicker'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-datepicker/android'),
        },
      },
    },
    'sample-native-datepicker-classic': { // <--------- Add entry for "sample-native-datepicker-classic"
      root: path.resolve(__dirname, './sample-native-datepicker-classic'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-datepicker-classic/android'),
        },
      },
    },
  },
};
