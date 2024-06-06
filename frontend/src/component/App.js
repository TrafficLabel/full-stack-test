import React from "react";
import Display from "./Display";
import ButtonPanel from "./ButtonPanel";
import calculate from "../logic/calculate";
import "./App.css";
import HistoryList from "./HistoryList";

export default class App extends React.Component {
  state = {
    total: null,
    next: null,
    operation: null,
  };

  handleClick = buttonName => {
    this.setState(calculate(this.state, buttonName));
  };

  render() {
    return (
      <div style={{ display: 'flex' }}>
        <div className="component-app" style={{ flex: 1 }}>
          <Display value={this.state.next || this.state.total || "0"} />
          <ButtonPanel clickHandler={this.handleClick} />
        </div>
        <div style={{ width: 250, backgroundColor: 'white' }}>
          <HistoryList />
        </div>
      </div>
    );
  }
}
