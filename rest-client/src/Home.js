import React, { Component } from "react";
import PropTypes from 'prop-types';
import axios from 'axios';
import { withStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import MenuItem from '@material-ui/core/MenuItem';
import 'react-notifications/lib/notifications.css';
import { NotificationContainer, NotificationManager } from 'react-notifications';

var apiBaseUrl = "http://localhost:8080/rest";

const styles = theme => ({
	container : {
		align : 'center',
		flexWrap : 'wrap',
	},
	textField : {
		marginLeft : theme.spacing.unit,
		marginRight : theme.spacing.unit,
		width : 200,
	},
	button : {
		marginLeft : theme.spacing.unit,
		marginRight : theme.spacing.unit,
		width : 200,
	},
	menu : {
		width : 200,
	},
});

const departments = [
	{
		value : 'ECE',
		label : 'ece',
	},
	{
		value : 'CSE',
		label : 'cse',
	},
	{
		value : 'IT',
		label : 'it',
	},
	{
		value : 'EEE',
		label : 'eee',
	},
];
class Home extends Component {

	constructor(props) {
		super(props);
		// initial state
		this.state = {
			rollnumber : '',
			name : '',
			firstname : '',
			lastname : '',
			department : '',
			startyear : '',
			endyear : ''
		};
	//		this.clear = this.clear.bind(this);
	}

	handleChange = name => event => {
		this.setState({
			[name] : event.target.value,
		});
	};

	clear = () => {
		// return the state to initial
		this.setState({
			rollnumber : '',
			name : '',
			firstname : '',
			lastname : '',
			department : '',
			startyear : '',
			endyear : ''
		});
	}

	render() {
		const {classes} = this.props;
		const {clear} = this.state;
		return (
			<div className='rowC'>
       
		 <div> 
	        <p>Please add a Student here.</p>
			<TextField
			id="rollnumber"
			label="Enter Rollnumber"
			className={classes.textField}
			value={this.state.rollnumber}
			onChange={this.handleChange('rollnumber')}
			margin="normal"
			/>
			<TextField
			id="name"
			label="Enter Name"
			className={classes.textField}
			value={this.state.name}
			onChange={this.handleChange('name')}
			margin="normal"
			/><br></br>
			<TextField
			id="firstname"
			label="Enter FirstName"
			className={classes.textField}
			value={this.state.firstname}
			onChange={this.handleChange('firstname')}
			margin="normal"
			/>
			<TextField
			id="lastname"
			label="Enter LastName"
			className={classes.textField}
			value={this.state.lastname}
			onChange={this.handleChange('lastname')}
			margin="normal"
			/><br></br>
			<TextField
			id="department"
			select
			label="Select"
			className={classes.textField}
			value={this.state.department}
			onChange={this.handleChange('department')}
			SelectProps={{
				MenuProps : {
					className : classes.menu,
				},
			}}
			helperText="Please select your currency"
			margin="normal"
			>
	        {departments.map(option => (
				<MenuItem key={option.value} value={option.value}>
	            {option.label}
	          </MenuItem>
			))}
	      </TextField>
	      <TextField
			id="startyear"
			label="Enter Start Year"
			value={this.state.startyear}
			onChange={this.handleChange('startyear')}
			type="number"
			className={classes.textField}
			InputLabelProps={{
				shrink : true,
			}}
			margin="normal"
			/><br></br>
			<TextField
			id="endyear"
			label="Enter End Year"
			value={this.state.endyear}
			onChange={this.handleChange('endyear')}
			className={classes.textField}
			type="number"
			InputLabelProps={{
				shrink : true,
			}}
			margin="normal"
			/><br></br>
			 <Button className={classes.button} variant="raised" color="primary" onClick={(event) => this.handleClick(event)}> Add Student </Button>
			 <NotificationContainer/></div>
		 <div><h1>This can be used 2</h1></div>
         </div>



			);
	}

	handleClick(event) {
		/**
		 * Call the server side and send the parameters.
		 */

		var payload = {
			"rollNumber" : this.state.rollnumber,
			"name" : this.state.name,
			"firstName" : this.state.firstname,
			"lastName" : this.state.lastname,
			"department" : this.state.department,
			"startYear" : this.state.startyear,
			"endYear" : this.state.endyear,
		}


		axios.post(apiBaseUrl + '/student', payload)
			.then(function(response) {
				console.log("Response Status:" + response.status);
				if (response.status == 200) {
					NotificationManager.success('Success message', 'Student Added Successfully');
				} else if (response.status == 401) {
					console.log("Username password do not match");
					alert(response.data.success)
				} else {
					console.log("Username does not exists");
					alert("Username does not exist");
				}
			})
			.catch(function(error) {
				NotificationManager.error('Internal Server Error', 'Error', 1000, () => {
				});
			});
	}
}

Home.propTypes = {
	classes : PropTypes.object.isRequired,
};

export default withStyles(styles)(Home);