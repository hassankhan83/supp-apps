import React, { Component } from "react";
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

var apiBaseUrl = "http://localhost:8080/rest";

const CustomTableCell = withStyles(theme => ({
	head : {
		backgroundColor : theme.palette.common.black,
		color : theme.palette.common.white,
	},
	body : {
		fontSize : 14,
	},
}))(TableCell);

const styles = theme => ({
	root : {
		width : '100%',
		marginTop : theme.spacing.unit * 3,
		overflowX : 'auto',
	},
	table : {
		minWidth : 700,
	},
	row : {
		'&:nth-of-type(odd)' : {
			backgroundColor : theme.palette.background.default,
		},
	},
});

class View extends Component {

	constructor(props) {
		super(props);
		this.state = {
			rows : [],
			isLoading : true,
		};
	}

	componentDidMount() {
		fetch(apiBaseUrl + '/student')
			.then(response => response.json())
			.then(data => this.setState({
				rows : data.data,
				isLoading : false
			}));
	}

	render() {
		const {classes} = this.props;
		const {rows, isLoading} = this.state;

		if (isLoading) {
			return <p>Loading ...</p>;
		}
		return (
			<div>
				<p>List of all available students</p>
				<Paper className={classes.root}>
			      <Table className={classes.table}>
			        <TableHead>
			          <TableRow>
			            <TableCell>Roll Number</TableCell>
			            <TableCell>Name</TableCell>
			            <TableCell>FirstName</TableCell>
			            <TableCell>LastName</TableCell>
			            <TableCell>Department</TableCell>
			            <TableCell>StartYear</TableCell>
			            <TableCell>EndYear</TableCell>
			          </TableRow>
			        </TableHead>
			        <TableBody>
			          {rows.map(row => {
				return (
					<TableRow className={classes.row} key={row.id}>
					                <TableCell component="th" scope="row">
					                  {row.rollNumber}
					                </TableCell>
					                <TableCell>{row.name}</TableCell>
					                <TableCell>{row.firstName}</TableCell>
					                <TableCell>{row.lastName}</TableCell>
					                <TableCell>{row.department}</TableCell>
					                <TableCell>{row.startYear}</TableCell>
					                <TableCell>{row.endYear}</TableCell>
					              </TableRow>
					);
			})}
			        </TableBody>
			      </Table>
			    </Paper>
			</div>
			);
	}


}
View.propTypes = {
	classes : PropTypes.object.isRequired,
};

export default withStyles(styles)(View);