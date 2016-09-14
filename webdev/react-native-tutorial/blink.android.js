import React, { Component } from 'react';
import { AppRegistry, Text, View } from 'react-native';

class Blink extends Component {
  constructor(props) {
  	super(props);
  	this.state = {showText: true};

  	//toggle state every second
  	setInterval(() => {
  	  this.setStat({ showText: !this.state.showText });
  	}, 1000);
  }

  render() {
  	let display = this.state.showTexd ? this.props.text : ' ';
  	return (
  	  <Text>{display}</Text>
    );
  }
}

class BlinkApp extends Component {
  render() {
  	return (
  	  <View>
  	    <Blink text='I am blinking so much' />
  	    <Blink text='Blinking is the greatest' />
  	    <Blink text='Watch how I blink like so' />
  	  </View>
  	);
  }
}

AppRegistry.registerComponent('BlinkApp', () => BlinkApp);