(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]
            [midje.sweet :refer :all]))


(facts "born to be dead"
       (let [board #{ [1 1] [2 2] [3 1] } ]
          (fact "first generation"
                (first (generations board) ) => #{[2 2] [1 1] [3 1]})
          (fact "second generation"
                (second (generations board) ) => #{[2 2] [2 1]})
          (fact "third generation"
                (nth (generations board) 2 ) => #{})
          (fact "fourth generation"
                (nth (generations board) 3 ) => #{})
          )
       )

(facts "forever young"
       (let [board #{ [1 3] [2 3] [3 3] [3 2] [2 1] } ]
          (fact "first generation"
                (first (generations board) ) => #{[1 3] [2 3] [3 3] [3 2] [2 1]} )
          (fact "second generation"
                (second (generations board) ) => #{[1 2] [2 3] [2 4] [3 2] [3 3]})
          (fact "third generation"
                (nth (generations board) 2 ) => #{[1 3] [2 4] [3 2] [3 3] [3 4]})
          (fact "fourth generation"
                (nth (generations board) 3 ) => #{[2 2] [2 4] [3 3] [3 4] [4 3]})
          )
       )

(facts "block"
       (let [board #{ [2 2] [2 3] [3 2] [3 3]} ]
          (fact "second generation"
                (second (generations board) ) => #{ [2 2] [2 3] [3 2] [3 3]} )
          (fact "third generation"
                (nth (generations board) 2 ) => #{[1 2] [2 3] [2 4] [3 2] [3 3]})
          )
       )
