(ns idla.random-walk
  (:require [idla.tools :as tools]))

(def directions [[0,1] [1,0] [0 -1] [-1 0]])

(defn random-direction 
  "get the list of possible diections and choose
   one direction uniform"
  []
  (nth directions (rand-int (count directions))))

(defn transition
 "get the current state and and a chosen direction and 
  return the new state"
 [state]
 (tools/plus state (random-direction)))

(def start  {:t 0
             :value [0,0]})

(defn step 
  "one step of a random walk"
  [walk]
  (-> (update walk :t inc)
      (update :value transition)))

(defn stop-after-n [n process]
  (>= (:t process) n))

(defn stop-on-exiting 
  "stop a walk if it exits the set A"
  [A walk]
  (not (tools/seq-contains? A (:value walk))))

(defn walk-until
  "input : walk : start of a walk
           step-fn : fn which describes the transitions 
                    of the walk
           stop? : fn of the current state returning true
                    if the walk shall stop; else false
   output : the walk at the point where it was stopped by stop?"
  ([walk stop?] 
   (walk-until walk transition stop?))
  ([walk step-fn stop?]
  (loop [state walk] 
    (if-not (stop? state) 
      (recur (step state))
      state))))



