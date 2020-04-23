(ns idla.tools
  (:require [clojure.data.json :as json]))

(defn save-idla-in-json
  ([idla-atom]
   (save-idla-in-json idla-atom "resources/IDLAs/data/idla.json"))
  ([idla file-name]
   (->>  (json/write-str idla)
         (spit file-name))))

(defn seq-contains? [coll target] (some #(= target %) coll))

(defn plus
  "vectorsum of sequences"
  [& seqs]
  (apply map + seqs))



