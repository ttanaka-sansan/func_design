(ns func-design.ch3)

(defn fibs-work [n i fs]
  (if (= i n)
    fs
    (recur n (inc i) (conj fs (apply + (take-last 2 fs))))))

(defn fib [n]
  (cond
    (< n 1) []
    (= n 1) [1]
    :else (fibs-work n 2 [1 1])))

(fib 10)

(defn ifib
  ([n a b]
   (if (= 0 n)
     b
     (recur (dec n) b (+ a b))))
  ([n]
   (cond
     (< n 1) nil
     (<= n 2) 1
     :else (ifib (- n 2) 1 1))))

(ifib 10)

(declare mfib)

(defn fib-w [n]
  (cond
    (< n 1) nil
    (<= n 2) 1
    :else (+ (mfib (dec n)) (mfib (- n 2)))))

(def mfib (memoize fib-w))

(mfib 50)

