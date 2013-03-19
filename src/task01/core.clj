(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))


(defn get-links []
" 1) Find all elements containing {:class \"r\"}.

Example:
[:h3 {:class \"r\"} [:a {:shape \"rect\", :class \"l\",
                         :href \"https://github.com/clojure/clojure\",
                         :onmousedown \"return rwt(this,'','','','4','AFQjCNFlSngH8Q4cB8TMqb710dD6ZkDSJg','','0CFYQFjAD','','',event)\"}
                     [:em {} \"clojure\"] \"/\" [:em {} \"clojure\"] \" · GitHub\"]]

   2) Extract href from the element :a.

The link from the example above is 'https://github.com/clojure/clojure'.

  3) Return vector of all 10 links.

Example: ['https://github.com/clojure/clojure', 'http://clojure.com/', . . .]
"
 (def resv (atom []))
 (let [data (parse "clojure_google.html")]
          ((fn fdd[x]  (doseq [y x] (if (coll? y) (if (and (= (first y) :h3) (= (:class (get y 1)) "r"))
             (swap! resv conj (:href (get (get y 2) 1))) (fdd y))) x)) data))
               @resv)


(defn -main []
  (println (str "Found " (count (get-links)) " links!")))


