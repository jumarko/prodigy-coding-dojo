(ns koans.01-equalities
  (:require [koan-engine.core :refer :all]))

; following solution is simplified and works only for very simple cases
(defn count-head [ht-list] 
  (count 
    (filter #(= :h %) ht-list)))

(defn head-tail [ht-list] 
  (if (< (count-head ht-list) 2)
      0
      (/ (count-head ht-list) 2)
    )
  )

; complete solution using the reduce function
(defn head-tail2 [ht-list] 
  (last
  (reduce (fn [a b] 
            (if (and (= (first a) b) (= b :h))
              [b, (+ (last a) 1)]
              [b, (last a)]
              )) [:t, 0] ht-list))
  )

; complete solution via recursion
(defn ht [head, tail] 
  (if (empty? tail) 
    0
    (if (= head (first tail) :h)
    (+ 1 (ht (first tail) (rest tail)))
    (ht (first tail) (rest tail))
    )
    )
  )

(defn head-tail-rec [ht-list] 
    (ht (first ht-list) (rest ht-list))
  )

(meditations
  "Empty"
  (= 1 (head-tail-rec '() ))

  "Single head"
  (= 0 (head-tail-rec '(:h) ))

  "One pair"
  (= 1 (head-tail-rec '(:h :h) ))

  "Two pairs"
  (= 2 (head-tail-rec '(:h :h :t :h :h) ))

  "One triple"
  (= 2 (head-tail-rec '(:h :h :h) ))
  
  "One triple  and two pairs"
  (= 4 (head-tail-rec '(:t :h :h :h :t :h :h :t :t :h :h) ))
  
  "One pair with t"
  (= 1 (head-tail-rec '(:t :h :h) ))
)
