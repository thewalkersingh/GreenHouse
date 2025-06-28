import {Component} from "react";
import '../styles/General.module.css';

export default class Contacts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "Diwakar Singh",
            contactphone: "4732897651",
            contactemail: "imfreak47@gmail.com"
        }
    }
    
    render() {
        return (
            <div className="contacts">
                <h1 className="contacts-details">Our Contacts</h1>
                <p>Name : {this.state.name}</p>
                <p>Phone: {this.state.contactphone}</p>
                <p>Email: {this.state.contactemail}</p>
            </div>
        )
    }
}