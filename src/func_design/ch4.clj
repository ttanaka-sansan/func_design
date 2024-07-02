(ns func-design.ch4)

(declare fib)

(defn fib-w [n]
  (cond
    (< n 1) nil
    (<= n 2) 1
    :else (+ (fib (dec n)) (fib (- n 2)))))

(def fib (memoize fib-w))

(defn lazy-fibs []
  (map fib (rest (range))))

(take 10 (lazy-fibs))
(nth (lazy-fibs) 50)
