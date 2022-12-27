/**
 * @format
 */

import 'react-native';
import renderer from 'react-test-renderer';

import { App } from '../src/App';

// Note: test renderer must be required after react-native.

test('renders correctly', async () => {
  await renderer.act(() => {
    const result = renderer.create(<App />);

    expect(result.toJSON()).toBeDefined();
  });
});
