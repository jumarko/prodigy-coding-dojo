 (ns fun-sort)

; sort collection x by values of f applied to elements of collection
; the whole point is to made sorting efficient by avoiding unnecessary invocations of key-fn
(§defn schwartz [coll key-fn]
  ; extract first items from sorted list of pairs
  (map
    (fn [x] (nth x 0))
    ; sort temporary list of pairs by second item (result of function applied to element of coll)
    (sort-by
      (fn [y] (nth y 1) )
      ; create temporary list of pairs ( (x1 f(x1)), (x2, f(x2)), ..., (xn, f(xn)) )
      (map
        (fn [z] (list z (key-fn z)))
        coll
        ))
    )
  )

; rewrite schwartz using anonymous function literal #()
(defn schwartz-an [coll key-fn]
  ; extract first items from sorted list of pairs
  (map #(nth %1 0)
    ; sort temporary list of pairs by second item (result of function applied to element of coll)
    (sort-by #(nth %1 1)
      ; create temporary list of pairs ( (x1 f(x1)), (x2, f(x2)), ..., (xn, f(xn)) )
      (map #(list %1 (key-fn %1))
        coll
        ))
    )
  )

(schwartz (list "a" "abc" "ab") (fn [x] (do (println "counting x") (count x))))
;counting x                                                                               │
;counting x                                                                               │
;counting x                                                                               │
;("a" "ab" "abc

; Compare to alternative
(sort-by (list "a" "abc" "ab") (fn [x] (do (println "counting x") (count x))))
;counting x                                                                               │
;counting x                                                                               │
;counting x                                                                               │
;counting x                                                                               │
;counting x                                                                               │
;counting x                                                                               │
;counting x                                                                               │
;counting x
;("a" "ab" "abc


