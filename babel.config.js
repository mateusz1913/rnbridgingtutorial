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
          samplenativemodule: './SampleNativeModule',
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
