const path = require('path');

module.exports = {
  dependencies: {
    'app-info-package': { // <--------- Add entry for "app-info-package"
      root: path.resolve(__dirname, './app-info-package'),
    },
    'app-info-package-classic': { // <--------- Add entry for "app-info-package-classic"
      root: path.resolve(__dirname, './app-info-package-classic'),
    },
    'conic-gradient-package': { // <--------- Add entry for "conic-gradient-package"
      root: path.resolve(__dirname, './conic-gradient-package'),
    },
    'conic-gradient-package-classic': { // <--------- Add entry for "conic-gradient-package-classic"
      root: path.resolve(__dirname, './conic-gradient-package-classic'),
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
    'sample-event-module': { // <--------- Add entry for "sample-event-module"
      root: path.resolve(__dirname, './sample-event-module'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-event-module/android'),
        },
      },
    },
    'sample-event-module-classic': { // <--------- Add entry for "sample-event-module-classic"
      root: path.resolve(__dirname, './sample-event-module-classic'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-event-module-classic/android'),
        },
      },
    },
    'sample-native-slider': { // <--------- Add entry for "sample-native-slider"
      root: path.resolve(__dirname, './sample-native-slider'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-slider/android'),
        },
      },
    },
    'sample-native-slider-classic': { // <--------- Add entry for "sample-native-slider-classic"
      root: path.resolve(__dirname, './sample-native-slider-classic'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-slider-classic/android'),
        },
      },
    },
    'sample-native-screen': { // <--------- Add entry for "sample-native-screen"
      root: path.resolve(__dirname, './sample-native-screen'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-screen/android'),
        },
      },
    },
    'sample-native-screen-classic': { // <--------- Add entry for "sample-native-screen-classic"
      root: path.resolve(__dirname, './sample-native-screen-classic'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-screen-classic/android'),
        },
      },
    },
    'sample-native-list': { // <--------- Add entry for "sample-native-list"
      root: path.resolve(__dirname, './sample-native-list'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-list/android'),
        },
      },
    },
    'sample-native-list-classic': { // <--------- Add entry for "sample-native-list-classic"
      root: path.resolve(__dirname, './sample-native-list-classic'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-native-list-classic/android'),
        },
      },
    },
  },
};
