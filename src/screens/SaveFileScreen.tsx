import { useRoute } from '@react-navigation/native';
import type { FC } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { SaveFilePickerModule } from 'save-file-picker-package';
import { SaveFilePickerClassicModule } from 'save-file-picker-package-classic';

import type { SaveFileRouteProp } from '../navigation';

const ASSETS_FILE_PATH = 'file.html';

export const SaveFileScreen: FC = () => {
  const route = useRoute<SaveFileRouteProp>();
  const isClassicModule = !!route.params?.isClassic;

  const saveFileWithCallback = () => {
    SaveFilePickerModule.saveFileWithCallback(ASSETS_FILE_PATH, (result) => {
      console.log(result);
    });
  };

  const saveFileWithPromise = async () => {
    try {
      const isSuccess = await SaveFilePickerModule.saveFileWithPromise(ASSETS_FILE_PATH);

      console.log({ isSuccess });
    } catch (error) {
      console.log({ error });
    }
  };

  const saveFileWithCallbackClassic = () => {
    SaveFilePickerClassicModule.saveFileWithCallback(ASSETS_FILE_PATH, (result) => {
      console.log(result);
    });
  };

  const saveFileWithPromiseClassic = async () => {
    try {
      const isSuccess = await SaveFilePickerClassicModule.saveFileWithPromise(ASSETS_FILE_PATH);

      console.log({ isSuccess });
    } catch (error) {
      console.log({ error });
    }
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.header}>Save file picker</Text>
        <View style={styles.body}>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? saveFileWithCallbackClassic : saveFileWithCallback} title="Save file (Callback)" />
          </View>
          <View style={styles.buttonWrapper}>
            <Button onPress={isClassicModule ? saveFileWithPromiseClassic : saveFileWithPromise} title="Save file (Promise)" />
          </View>
        </View>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  body: {
    alignItems: 'center',
    alignSelf: 'stretch',
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 20,
  },
  buttonWrapper: {
    alignSelf: 'stretch',
    paddingVertical: 30,
  },
  container: {
    alignItems: 'center',
    alignSelf: 'stretch',
    flex: 1,
    justifyContent: 'center',
  },
  header: {
    fontSize: 24,
    fontWeight: 'bold',
    paddingVertical: 20,
    textTransform: 'capitalize',
  },
  safeArea: {
    alignSelf: 'stretch',
    flex: 1,
  },
});