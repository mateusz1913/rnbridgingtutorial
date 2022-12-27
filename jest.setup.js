// Mock FormData in tests with RN implementation
global.FormData = require('react-native/Libraries/Network/FormData');

jest.mock('react-native', () => {
  const RN = jest.requireActual('react-native');

  // Example of mocking `NativeModules`
  // RN.NativeModules.MyAwesomeModule = {
  //   myAwesomeMethod: jest.fn(),
  // }
  return RN;
});

jest.mock('react-native/Libraries/EventEmitter/NativeEventEmitter');
jest.mock('react-native/Libraries/Animated/NativeAnimatedHelper');
