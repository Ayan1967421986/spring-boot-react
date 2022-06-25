import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CardList from './CardList';
import CardEdit from "./CardEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/cards' exact={true} component={CardList}/>
            <Route path='/cards/:id' component={CardEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;