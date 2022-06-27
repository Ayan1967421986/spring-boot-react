import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class CardEdit extends Component {

    emptyItem = {
        cardHolderName: '',
        cardNumber: '',
        cardLimit: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const card = await (await fetch(`/v1/cards/${this.props.match.params.id}`)).json();
            this.setState({item: card});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/v1/cards' + (item.id ? '/' + item.id : ''), {
        method: (item.id) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/v1/cards');
}

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Card' : 'Add Card'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="cardHolderName">CardHolder Name</Label>
                        <Input type="text" name="cardHolderName" id="cardHolderName" value={item.cardHolderName || ''}
                               onChange={this.handleChange} autoComplete="cardHolderName"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="cardNumber">Card Number</Label>
                        <Input type="text" name="cardNumber" id="cardNumber" value={item.cardNumber || ''}
                               onChange={this.handleChange} autoComplete="cardNumber"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="cardLimit">Card Limit</Label>
                        <Input type="text" name="cardLimit" id="cardLimit" value={item.cardLimit || ''}
                               onChange={this.handleChange} autoComplete="cardLimit"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/cards">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(CardEdit);