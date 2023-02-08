module.exports = {
  presets: [ 'module:metro-react-native-babel-preset' ],
  plugins: [
    [
      'module-resolver',
      {
        root: [ './' ],
        extensions: [
          '.ios.js',
          '.ios.ts',
          '.ios.tsx',
          '.android.js',
          '.android.ts',
          '.android.tsx',
          '.js',
          '.ts',
          '.tsx',
          '.json',
        ],
        alias: {
          'sample-native-module': './sample-native-module',
          'sample-native-module-classic': './sample-native-module-classic',
          'sample-native-datepicker': './sample-native-datepicker',
          'sample-native-datepicker-classic': './sample-native-datepicker-classic',
          'sample-event-module': './sample-event-module',
          'sample-event-module-classic': './sample-event-module-classic',
          'sample-react-view': './sample-react-view',
          'sample-react-view-classic': './sample-react-view-classic',
          'sample-native-slider': './sample-native-slider',
          'sample-native-slider-classic': './sample-native-slider-classic',
        },
      },
    ],
    [
      '@babel/plugin-transform-react-jsx',
      {
        runtime: 'automatic',
      },
    ],
  ],
};
