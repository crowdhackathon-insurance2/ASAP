

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
} from 'react-native';
import NavigationExperimental from 'react-native-deprecated-custom-components';

import StartPage from './app/components/StartPage';
import RunningPage from './app/components/RunningPage';
import MyScore from './app/components/MyScore';
import MyBadges from './app/components/MyBadges';
import MyAlert from './app/components/MyAlert';
export default class projectX extends Component {
  render() {
    return (
        //build the navigation router
        <NavigationExperimental.Navigator initialRoute = {{id:StartPage}}
          renderScene = {this.navigatorRenderScene} />
    );
  }
  navigatorRenderScene(route,navigator) {
    _navigator = navigator;
    switch (route.id) {
      case StartPage:
        return (<StartPage navigator = {navigator}/>);
      case RunningPage:
        return (<RunningPage navigator = {navigator}/>);
      case MyScore:
        return (<MyScore navigator = {navigator}/>);
      case MyBadges:
        return (<MyBadges navigator = {navigator}/>);
      case MyAlert:
        return (<MyAlert navigator = {navigator}/>);

    }
  }
}


AppRegistry.registerComponent('projectX', () => projectX);
