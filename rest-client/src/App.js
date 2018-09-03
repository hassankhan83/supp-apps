import React, { Component } from "react";
 import {
  Route,
  NavLink,
  HashRouter
} from "react-router-dom";
import Home from "./Home";
import View from "./View";
import Contact from "./Contact";
class App extends Component {
  render() {
    return (
	<HashRouter>
        <div>	
          <h1>React-Client</h1>
          <ul className="header">
            <li><NavLink exact to="/">Home</NavLink></li>
            <li><NavLink to="/View">View</NavLink></li>
            <li><NavLink to="/contact">Contact</NavLink></li>
          </ul>
          <div className="content">
             <Route exact path="/" component={Home}/>
            <Route path="/View" component={View}/>
            <Route path="/contact" component={Contact}/>
          </div>
        </div>
		</HashRouter>
    );
  }
}
 
export default App;