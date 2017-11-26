import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Image,
  TextInput,
  TouchableOpacity,
  AsyncStorage,
} from 'react-native';

import StartPage from './StartPage';

export default class MyBadges extends Component {
  state = {
    username : 'default',
    score : 'default',
  }
  componentDidMount(){
      this._loadInitialState().done();
  }
  _loadInitialState = async () => {
      var namevalue = await AsyncStorage.getItem('username');
      var scorevalue = await AsyncStorage.getItem('score');
      if(namevalue !== null)
          this.setState({username: namevalue});
      else
        alert('cant find name');

  }
  showBadges = () => {
	var username = 'Michael';
	AsyncStorage.setItem('username',username);
	this.props.navigator.push({
              id : MyBadges
            });


}
  goToStart = () => {
	
	this.props.navigator.push({
              id : StartPage
            });


}
  render() {
    return (
	<View style = {styles.container}>
        <Image source={require('../img/dead_straight_highway_though_eastern_nevada_with_clear_blue_sky.jpg')} style = {styles.backgroundImage}>
            <View style = {styles.content}>
		
		
                <View style = {styles.inputContainer} >
		<Text style = {styles.SText}> {this.state.username}, your Badges </Text>

              	<Image source={require('../img/icons/0-100-challenge.jpg')} style={{width: 40, height: 40 , marginBottom: 10 , borderRadius :30}} />
		<Image source={require('../img/icons/0-calendar.jpg')} style={{width: 40, height: 40 , marginBottom: 10 , borderRadius :30}} />
		<Image source={require('../img/icons/0-eco-drive.jpg')} style={{width: 40, height: 40 , marginBottom: 10 , borderRadius :30}} />

                    <TouchableOpacity onPress={this.goToStart} style = {styles.topbuttonContainer}>
                        <Text style={styles.SText}> Return </Text>
                    </TouchableOpacity>


                </View>
            </View>
        </Image>
      </View>
    );
  }

}
const styles = StyleSheet.create({
  container: {
    flex:1,
  },
  backgroundImage: {
    flex:1,
    alignSelf: 'stretch',
    width: null,
    justifyContent : 'center',
  },
  content :{
    alignItems: 'center',
  },
  logoup :{
    color : 'white',
    fontSize : 50,
    fontStyle : 'italic',
    fontWeight : 'bold',
    textShadowColor : '#252525',
    textShadowOffset : {width : 2,height : 4},
    textShadowRadius : 15,
    marginBottom : 5,

  },
  logo :{
    color : 'white',
    fontSize : 50,
    fontStyle : 'italic',
    fontWeight : 'bold',
    textShadowColor : '#252525',
    textShadowOffset : {width : 2,height : 4},
    textShadowRadius : 15,
    marginBottom : 5,

  },
  inputContainer:{
    margin : 20,
    marginBottom : 0,
    padding : 20,
    paddingBottom : 10,
    alignSelf : 'stretch',
    alignItems: 'center',
    borderWidth : 1,
    borderColor : '#fff',
    borderRadius :15,
    backgroundColor : 'rgba(255,255,255,0.2)',
  },
  input: {
    fontSize : 16,
    height : 40,
    padding : 10,
    marginBottom : 10,
    borderRadius :15,
    backgroundColor : 'rgba(255,255,255,1)',
  },
  topbuttonContainer: {
    
    margin : 10,
    padding : 5,
    backgroundColor : 'black',
    borderWidth : 1,
    borderColor : '#fff',
    borderRadius :15,
    backgroundColor : 'rgba(255,255,255,0.6)',
    marginTop : 0,
  },
  spbuttonContainer: {
    
    padding : 5,
    backgroundColor : 'black',
    borderWidth : 1,
    borderColor : '#fff',
    borderRadius :15,
    backgroundColor : 'rgba(255,255,255,0.6)',
    marginTop : 0,
  },
  buttonContainer: {
    alignSelf: 'stretch',
    margin : 20,
    padding : 10,
    backgroundColor : 'black',
    borderWidth : 1,
    borderColor : '#fff',
    borderRadius :15,
    backgroundColor : 'rgba(255,255,255,0.6)',
  },
  StartbuttonText: {
    fontSize : 20,
    color : '#00CC00',
    fontWeight : 'bold',
    textAlign : 'center',
  }
   ,
  StopbuttonText: {
    fontSize : 20,
    color : '#CC0000',
    fontWeight : 'bold',
    textAlign : 'center',
  },
  SText: {
    fontSize : 20,
    color : '#252552',
    fontWeight : 'bold',
    textAlign : 'center',
    marginBottom : 10 ,
    marginTop : 10,
  }


});
