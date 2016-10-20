import React, { Component } from 'react';
import { AppRegistry, Text } from 'react-native';

class Bananas extends Component {
  render() {
    let pic = {
      uri: 'https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg'
    };;
  }
}

AppRegistry.registerComponent('Banans', () => Bananas);