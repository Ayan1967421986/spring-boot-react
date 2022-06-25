import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class CardList extends Component {

    constructor(props) {
        super(props);
        this.state = {cards: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/v1/cards')
            .then(response => response.json())
            .then(data => this.setState({cards: data}));
    }

    async remove(id) {
        await fetch(`/v1/cards/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCards = [...this.state.cards].filter(i => i.id !== id);
            this.setState({cards: updatedCards});
        });
    }

    render() {
        const {cards} = this.state;

        const cardList = cards.map(card => {
            return <tr key={card.id}>
                <td style={{whiteSpace: 'nowrap'}}>{card.cardHolderName}</td>
                <td style={{whiteSpace: 'nowrap'}}>{card.cardNumber}</td>
                <td style={{whiteSpace: 'nowrap'}}>{card.balance}</td>
                <td style={{whiteSpace: 'nowrap'}}>{card.cardLimit}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/cards/" + card.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(card.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/cards/new">Add Card</Button>
                    </div>
                    <h3>Cards</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="15%">CardHolder Name</th>
                            <th width="15%">Card Number</th>
                            <th width="15%">Card Balance[£]</th>
                            <th width="15%">Card Limit[£]</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {cardList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default CardList;