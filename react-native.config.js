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
    'sample-react-view': { // <--------- Add entry for "sample-react-view"
      root: path.resolve(__dirname, './sample-react-view'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-react-view/android'),
        },
      },
    },
    'sample-react-view-classic': { // <--------- Add entry for "sample-react-view-classic"
      root: path.resolve(__dirname, './sample-react-view-classic'),
      platforms: {
        android: {
          sourceDir: path.resolve(__dirname, './sample-react-view-classic/android'),
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
  },
};
