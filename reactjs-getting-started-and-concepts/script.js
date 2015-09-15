"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = (function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; })();

var _get = function get(_x, _x2, _x3) { var _again = true; _function: while (_again) { var object = _x, property = _x2, receiver = _x3; desc = parent = getter = undefined; _again = false; if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { _x = parent; _x2 = property; _x3 = receiver; _again = true; continue _function; } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } } };

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { "default": obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) subClass.__proto__ = superClass; }

var _react0133BuildReactJs = require("react-0.13.3/build/react.js");

var _react0133BuildReactJs2 = _interopRequireDefault(_react0133BuildReactJs);

var MyComponent = (function (_React$Component) {
    function MyComponent() {
        _classCallCheck(this, MyComponent);

        _get(Object.getPrototypeOf(MyComponent.prototype), "constructor", this).apply(this, arguments);
    }

    _inherits(MyComponent, _React$Component);

    _createClass(MyComponent, [{
        key: "render",
        value: function render() {
            return _react0133BuildReactJs2["default"].createElement(
                "h1",
                null,
                "Hello, ",
                this.props.name,
                "!"
            );
        }
    }]);

    return MyComponent;
})(_react0133BuildReactJs2["default"].Component);

exports["default"] = MyComponent;

_react0133BuildReactJs2["default"].render(_react0133BuildReactJs2["default"].createElement(MyComponent, { name: "Handsome" }), document.getElementById("mount-point"));

var Counter = (function (_React$Component2) {
    function Counter(props) {
        _classCallCheck(this, Counter);

        _get(Object.getPrototypeOf(Counter.prototype), "constructor", this).call(this, props);
        this.state = {
            count: 0
        };
    }

    _inherits(Counter, _React$Component2);

    _createClass(Counter, [{
        key: "incrementCount",
        value: function incrementCount() {
            this.setState({
                count: this.state.count + 1
            });
        }
    }, {
        key: "render",
        value: function render() {
            return _react0133BuildReactJs2["default"].createElement(
                "div",
                null,
                _react0133BuildReactJs2["default"].createElement(
                    "h1",
                    null,
                    "Count: ",
                    this.state.count
                ),
                _react0133BuildReactJs2["default"].createElement(
                    "button",
                    { type: "button", onClick: this.incrementCount },
                    "Increment"
                )
            );
        }
    }]);

    return Counter;
})(_react0133BuildReactJs2["default"].Component);

exports.Counter = Counter;

_react0133BuildReactJs2["default"].render(_react0133BuildReactJs2["default"].createElement(Counter, null), document.getElementById("counter"));

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

