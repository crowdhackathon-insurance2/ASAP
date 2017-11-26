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
import MyScore from './MyScore';
import MyBadges from './MyBadges';
import MyAlert from './MyAlert';
export default class RunningPage extends Component {
  constructor(props){
    super(props);
    this.state = {username:'',password:''};
    this.state = { speed: 50 };
    this.curTime = null;
  }
  
componentDidMount() {
    setInterval( () => {
      this.setState({
         speed: this.state.speed + 3 
      })
    },1000)
    
      this.timeoutHandle = setTimeout(()=>{
              this.props.navigator.push({
              id : MyAlert
            });
         }, 5000);

      
  }


 

showScore = () => {
	var username = 'Michael';
	AsyncStorage.setItem('username',username);
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
                        <Text style={styles.ScoreText}>My Score</Text>
                    </TouchableOpacity>
                
                <View style = {styles.inputContainer} >


              	
		    <Text style ={styles.logo}> CurrentSpeed: </Text>
		    <Text style ={styles.logo}> {this.state.speed}  </Text>

                    <TouchableOpacity onPress={this.showScore} style = {styles.buttonContainer}>
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
  
  
  logo :{
    color : 'white',
    fontSize : 20,
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
    alignItems: 'center',
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

