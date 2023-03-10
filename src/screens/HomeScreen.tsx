import type { FC } from 'react';
import { Button, ScrollView, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

import { ROUTES, useRootStackNavigation } from '../navigation';

export const HomeScreen: FC = () => {
  const navigation = useRootStackNavigation();

  const navigateToAppInfo = () => {
    navigation.navigate(ROUTES.APP_INFO);
  };

  const navigateToAppInfoClassic = () => {
    navigation.navigate(ROUTES.APP_INFO, { isClassic: true });
  };
  
  const navigateToConicGradient = () => {
    navigation.navigate(ROUTES.CONIC_GRADIENT);
  };

  const navigateToConicGradientClassic = () => {
    navigation.navigate(ROUTES.CONIC_GRADIENT, { isClassic: true });
  };

  const navigateToRangeSlider = () => {
    navigation.navigate(ROUTES.RANGE_SLIDER);
  };

  const navigateToRangeSliderClassic = () => {
    navigation.navigate(ROUTES.RANGE_SLIDER, { isClassic: true });
  };

  const navigateToSaveFilePicker = () => {
    navigation.navigate(ROUTES.SAVE_FILE);
  };

  const navigateToSaveFilePickerClassic = () => {
    navigation.navigate(ROUTES.SAVE_FILE, { isClassic: true });
  };

  const navigateToScreenOrientation = () => {
    navigation.navigate(ROUTES.SCREEN_ORIENTATION);
  };

  const navigateToNativeList = () => {
    navigation.navigate(ROUTES.NATIVE_LIST);
  };

  const navigateToNativeListClassic = () => {
    navigation.navigate(ROUTES.NATIVE_LIST, { isClassic: true });
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <Text style={styles.titleBarText}>Demo</Text>
      <View style={styles.container}>
        <View style={styles.header}>
          <Text style={styles.headerText}>Bridging tutorial</Text>
        </View>
        <ScrollView contentContainerStyle={styles.bodyContent} style={styles.body}>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToAppInfo} title="AppInfo" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToAppInfoClassic} title="AppInfo (Classic)" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToConicGradient} title="Conic gradient" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToConicGradientClassic} title="Conic gradient (Classic)" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToSaveFilePicker} title="Save file" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToSaveFilePickerClassic} title="Save file (Classic)" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToRangeSlider} title="Range slider" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToRangeSliderClassic} title="Range slider (Classic)" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToScreenOrientation} title="Screen orientation (Modern & Classic)" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToNativeList} title="Native List (Modern)" />
          </View>
          <View style={styles.navigateLink}>
            <Button onPress={navigateToNativeListClassic} title="Native List (Classic)" />
          </View>
        </ScrollView>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  body: {
    alignSelf: 'stretch',
    flex: 1,
  },
  bodyContent: {
    alignItems: 'center',
    alignSelf: 'stretch',
    flexGrow: 1,
    justifyContent: 'center',
    paddingHorizontal: 20,
  },
  container: {
    alignItems: 'center',
    alignSelf: 'stretch',
    flex: 1,
    justifyContent: 'center',
  },
  header: {
    alignItems: 'center',
    justifyContent: 'center',
    margin: 20,
    paddingHorizontal: 20,
  },
  headerText: {
    fontSize: 30,
    fontWeight: 'bold',
    paddingVertical: 20,
    textTransform: 'capitalize',
  },
  navigateLink: {
    alignSelf: 'stretch',
    paddingVertical: 20,
  },
  safeArea: {
    alignSelf: 'stretch',
    flex: 1,
  },
  titleBarText: {
    fontSize: 16,
    fontWeight: 'bold',
    margin: 20,
  },
});
