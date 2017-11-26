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

import RunningPage from './RunningPage';
import MyScore from './MyScore';
import MyBadges from './MyBadges';
export default class StartPage extends Component {
  constructor(props){
    super(props);
    this.state = {username:'',password:''};
  }
goToRunningPage = () => {
	
	this.props.navigator.push({
              id : RunningPage
            });


}

goToStartPage = () => {
	
	this.props.navigator.push({
              id : StartPage
            });


}
showScore = () => {
	var username = 'Michael';
	AsyncStorage.setItem('username',username);
        var score = '190';
	AsyncStorage.setItem('score',score);
	this.props.navigator.push({
              id : MyScore
            });


}
  render() {
    return (
      <View style = {styles.container}>
        <Image source={require('../img/dead_straight_highway_though_eastern_nevada_with_clear_blue_sky.jpg')} style = {styles.backgroundImage}>
            <View style = {styles.content}>
		<TouchableOpacity onPress={this.showScore} style = {styles.topbuttonContainer}>
                        <Text style={styles.ScoreText}>MyScore</Text>
                    </TouchableOpacity>
                <Text style ={styles.logoup}> Welcome  </Text>
		<Text style ={styles.logo}> to ROSA  </Text>
                <View style = {styles.inputContainer} >


              	
		    <TouchableOpacity onPress={this.goToRunningPage} style = {styles.buttonContainer}>
                        <Text style={styles.StartbuttonText}>Start</Text>
                    </TouchableOpacity>

                    <TouchableOpacity onPress={this.goToStartPage} style = {styles.buttonContainer}>
                        <Text style={styles.StopbuttonText}>Stop</Text>
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
  ScoreText: {
    fontSize : 20,
    color : '#252552',
    fontWeight : 'bold',
    textAlign : 'center',
  }


});
