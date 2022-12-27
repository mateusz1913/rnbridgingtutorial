module.exports = {
  preset: 'react-native',
  transform: {
    '^.+\\.jsx$': 'babel-jest',
    '^.+\\.tsx?$': [
      'ts-jest',
      {
        tsconfig: 'tsconfig.spec.json',
      },
    ],
  },
  moduleFileExtensions: [ 'ts', 'tsx', 'js', 'jsx', 'json', 'node' ],
  moduleNameMapper: {},
  transformIgnorePatterns: [
    'node_modules/(?!(@react-native|react-native|navigation-react-native|react-native.*)/)',
  ],
  setupFilesAfterEnv: [
    '<rootDir>/jest.setup.js',
  ],
  collectCoverageFrom: [
    'src/**/*.{js,jsx,ts,tsx}',
    '!**/*.types.ts',
    '!**/node_modules/**',
    '!**/vendor/**',
  ],
  resetMocks: false,
};
