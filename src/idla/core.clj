(ns idla.core
  (:require [idla.random-walk :as rw]
            [idla.tools :as tools]))


(def start  {:t 0 
             :value ['(0 0)]})

(defn stopped-random-walk [A]
  "run a random walk until exiting the set A
   output: the value of the walk at time of stopping"
  (rw/walk-until rw/start (partial rw/stop-on-exiting A)))

(defn step
  "do one step of the idla process"
  [idla]
  (let [end-of-walk (stopped-random-walk  (:value idla))
        new-point (:value end-of-walk)]
    (-> (update idla :t inc)
        (update      :value #(conj % new-point)))))

(defn walk-idla-until-time-n
  ([n] (walk-idla-until-time-n start step n))
  ([process-start step-fn n]
   (nth (iterate step-fn process-start) n)))





