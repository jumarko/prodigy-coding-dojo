(ns game-of-life.core
  (:gen-class))


(require '[game-of-life.gorilla :as g])

(def board #{[2 1] [2 2] [2 3]})



(defn cell-neighbours [[x y]]
  (for [ dx [-1 0 1] dy  [-1 0 1] :when (not= 0 dx dy)] [(+ x dx) (+ y dy)]))


(defn neighbours [cells]
  "Return set of all neigbhours of given cells."
  (mapcat cell-neighbours cells))

(defn next-gen [current-gen]
  (let [neighs (neighbours current-gen)
        cells-group (group-by (fn [cell] cell) neighs)
        cells-count (map (fn [[k v]] [k (count v)]) cells-group)
        filtered-cells (filter (fn [[cell count]]
                                 (or (and (= count 2) (current-gen cell)) (= count 3))) cells-count)]

    (map (fn [[cell count]] cell) filtered-cells)))


(g/plot-cells board)
(g/plot-cells (next-gen board))
