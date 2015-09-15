import React from "react-0.13.3/build/react.js"

export default class MyComponent extends React.Component {
    render() {
        return (
            <h1>Hello, {this.props.name}!</h1>
        );
    }
}

React.render(
    <MyComponent name="Handsome"/>,
    document.getElementById("mount-point")
);

export class Counter extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            count: 0
        };
    }

    incrementCount() {
        this.setState({
            count: this.state.count + 1
        });
    }

    render() {
        return (<div>
                <h1>Count: {this.state.count}</h1>
                <button type="button" onClick={this.incrementCount}>Increment</button>
            </div>
        )
    }
}

      React.render(
              <Counter />,
              document.getElementById("counter")
      );


      /** Filtered list component*/
      //var FilteredList = React.createClass({
      //    filterList: function(event) {
      //        var updatedList = this.state.initialItems;
      //        updatedList = updatedList.filter(function(item) {
      //            return item.toLowerCase().search(
      //                            event.target.value.toLowerCase()) !== -1;
      //        });
      //        this.setState({items: updatedList});
      //    },
      //
      //    getInitialState: function () {
      //        return {
      //            initialItems: [
      //                "Apples",
      //                "Broccoli",
      //                "Chicken",
      //                "Duck",
      //                "Eggs",
      //                "Fish",
      //                "Granola",
      //                "Hash Browns"
      //            ],
      //            items: []
      //        }
      //    },
      //
      //    componentWillMount: function() {
      //        this.setState({items: this.state.initialItems});
      //    },
      //
      //    render: function() {
      //        return (
      //                <div className="filter-list">
      //                    <input type="text" placeholder="Search" onChange={this.filterList} />
      //                    <List items={this.state.items} />
      //                </div>
      //        )
      //    }
      //});
      //
      //var List = React.createClass({
      //            render: function() {
      //                return (
      //                        <ul>
      //                            {
      //                                    this.props.items.map(function(item) {
      //                                        return <li key={item}>{item}</li>
      //                                    })
      //                            }
      //                        </ul>
      //                )
      //            }
      //        }
      //);
      //
      //React.render(<FilteredList/>, document.getElementById('filtered-list'));
      //
