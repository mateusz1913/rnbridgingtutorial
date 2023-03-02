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
    'native-list-package': { // <--------- Add entry for "native-list-package"
      root: path.resolve(__dirname, './native-list-package'),
    },
    'native-list-package-classic': { // <--------- Add entry for "native-list-package-classic"
      root: path.resolve(__dirname, './native-list-package-classic'),
    },
    'range-slider-package': { // <--------- Add entry for "range-slider-package"
      root: path.resolve(__dirname, './range-slider-package'),
    },
    'range-slider-package-classic': { // <--------- Add entry for "range-slider-package-classic"
      root: path.resolve(__dirname, './range-slider-package-classic'),
    },
    'save-file-picker-package': { // <--------- Add entry for "save-file-picker-package"
      root: path.resolve(__dirname, './save-file-picker-package'),
    },
    'save-file-picker-package-classic': { // <--------- Add entry for "save-file-picker-package-classic"
      root: path.resolve(__dirname, './save-file-picker-package-classic'),
    },
    'screen-orientation-package': { // <--------- Add entry for "screen-orientation-package"
      root: path.resolve(__dirname, './screen-orientation-package'),
    },
    'screen-orientation-package-classic': { // <--------- Add entry for "screen-orientation-package-classic"
      root: path.resolve(__dirname, './screen-orientation-package-classic'),
    },
  },
};
